package com.kh.spring21.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring21.configuration.KakaoPayProperties;
import com.kh.spring21.vo.KakaoPayApproveRequestVO;
import com.kh.spring21.vo.KakaoPayApproveResponseVO;
import com.kh.spring21.vo.KakaoPayReadyRequestVO;
import com.kh.spring21.vo.KakaoPayReadyResponseVO;

import lombok.extern.java.Log;
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
}
