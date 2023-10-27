package com.kh.spring21.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring21.configuration.KakaoPayProperties;
import com.kh.spring21.dao.PaymentDao;
import com.kh.spring21.dao.ProductDao;
import com.kh.spring21.dto.ProductDto;
import com.kh.spring21.vo.KakaoPayApproveRequestVO;
import com.kh.spring21.vo.KakaoPayApproveResponseVO;
import com.kh.spring21.vo.KakaoPayCancelRequestVO;
import com.kh.spring21.vo.KakaoPayCancelResponseVO;
import com.kh.spring21.vo.KakaoPayDetailRequestVO;
import com.kh.spring21.vo.KakaoPayDetailResponseVO;
import com.kh.spring21.vo.KakaoPayReadyRequestVO;
import com.kh.spring21.vo.KakaoPayReadyResponseVO;
import com.kh.spring21.vo.PurchaseListVO;
import com.kh.spring21.vo.PurchaseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaoPayServiceImpl implements KakaoPayService{

	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	//준비 요청
	@Override
	public KakaoPayReadyResponseVO ready(KakaoPayReadyRequestVO request) throws URISyntaxException {
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//바디 설정
		//같은 이름도 처리 가능함 이런 값을 처리하기 위한 Map
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>(); 
		body.add("cid", kakaoPayProperties.getCid()); //가맹점번호
		body.add("partner_order_id", request.getPartnerOrderId()); //시리얼 번호가 랜덤으로 나옴(자바 클래스)
		body.add("partner_user_id", request.getPartnerUserId()); //구매자 아이디
		body.add("item_name", request.getItemName()); //구매자 상품명 2개 이상시 외 ?개
		body.add("quantity", "1"); //무조건 1, 수량은 DB에서 관리할거임
		body.add("total_amount", String.valueOf(request.getItemPrice())); //결제금액 개발자용은 100만원이 최대 
		body.add("tax_free_amount", "0"); //면세
		
		//현재 페이지 주소 계산
		String path = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
				
		body.add("approval_url", path+"/success");
		body.add("cancel_url", path+"/cancel");
		body.add("fail_url", path+"/fail");
		
		//요청 발송
		HttpEntity entity = new HttpEntity<>(body, headers); //바디+헤더
		
		KakaoPayReadyResponseVO response = 
				template.postForObject(uri, entity, KakaoPayReadyResponseVO.class);
		
		return response;
	}
	
	//승인 요청
	public KakaoPayApproveResponseVO approve(KakaoPayApproveRequestVO request) throws URISyntaxException {
		//주소
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//바디
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid",kakaoPayProperties.getCid()); //가맹점 번호
		body.add("tid", request.getTid()); //거래번호
		body.add("partner_order_id", request.getPartnerOrderId()); //가맹점 주문번호
		body.add("partner_user_id", request.getPartnerUserId()); //가맹점 회원id
		body.add("pg_token", request.getPgToken()); //결제승인 요청을 인증하는 토큰
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		KakaoPayApproveResponseVO response = 
				template.postForObject(uri, entity, KakaoPayApproveResponseVO.class);
		
		log.debug("결제 승인 완료 = {}", response.getTid());
		
		return response;
	};
	
	//주문 조회
	@Override
	public KakaoPayDetailResponseVO detail(KakaoPayDetailRequestVO request) throws URISyntaxException {
		//조회 주소
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//바디
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());
		body.add("tid", request.getTid());
		
		//요청 발송
		HttpEntity entity = new HttpEntity(body, headers);
		
		KakaoPayDetailResponseVO response = 
				template.postForObject(uri, entity, KakaoPayDetailResponseVO.class);
		return response;
	}
	
	@Override
	public KakaoPayCancelResponseVO cancel(KakaoPayCancelRequestVO request) throws URISyntaxException {
		//조회 주소
		URI uri = new URI("https://kapi.kakao.com/v1/payment/cancel");
		
		//바디
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());
		body.add("tid", request.getTid());
		body.add("cancel_amount", String.valueOf(request.getCancelAmount()));
		body.add("cancel_tax_free_amount", "0");
		
		//요청
		HttpEntity entity = new HttpEntity(body, headers);
		
		KakaoPayCancelResponseVO response = 
				template.postForObject(uri, entity, KakaoPayCancelResponseVO.class);
		
		return response;
	}
	
	@Override
	public KakaoPayReadyRequestVO convert(PurchaseListVO listVO) {
		//구매목록 추출
		List<PurchaseVO> list = listVO.getProduct(); 
		
		//결제 사용할 정보를 저장할 변수들
		String name = null;
		int total = 0;
		
		//구매목록을 모두 조사하여 상품정보 추출 후 필요한 항목을 계산
		for(PurchaseVO vo : list) {
			//vo 안에는 상품번호(productNo)와 구매수량(qty)가 있다
			ProductDto dto = productDao.selectOne(vo.getProductNo());
			if(name == null) { //이름이 없을 때만 이름을 넣어라(최초 이름만 들어감)
				name = dto.getProductName();
			}
			total += dto.getProductPrice() * vo.getQty(); //상품가격과 수량을 곱해서 합산
		}
		
		//구매 수량이 2개 이상이라면 이름에 외 ?건를 추가
		if(list.size() >= 2) {
			name += " 외 "+(list.size()-1)+"건"; //총 개수에서 1개를 빼준다
		}
		
		//partner_order_id에 결제번호를 집어넣으면 충돌도 없고 좋지 않을까
		int paymentNo = paymentDao.sequence();
		
		return KakaoPayReadyRequestVO.builder()
//					.partnerOrderId(UUID.randomUUID().toString())
					.partnerOrderId(String.valueOf(paymentNo))
					.itemName(name)
					.itemPrice(total)
				.build();
	}
}
