package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.vo.KakaoPayReadyRequestVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test03Ready {

	@Test
	public void test() throws URISyntaxException {
		//변하는 정보와 중요한 정보들을 분리하여 모듈로 개발
		
		//결제 준비 요청 정보를 클래스로 모듈화(KakaoPayReadyRequestVO)
		KakaoPayReadyRequestVO request = KakaoPayReadyRequestVO.builder()
				.partnerOrderId(UUID.randomUUID().toString())
				.partnerUserId("testuser1")
				.itemName("초코파이 1box")
				.itemPrice(3500)
				.build();
		
		//전송 도구 생성
		RestTemplate template = new RestTemplate();
		
		//주소 설정
		URI uri = new URI("https://kapi.kakao.com/v1/payment/ready");
		
		//헤더 설정
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 9aa12be03605854cc972d5ef9b56b181"); //문자열만 작성 가능
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		//바디 설정
		//같은 이름도 처리 가능함 이런 값을 처리하기 위한 Map
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>(); 
		body.add("cid", "TC0ONETIME"); //가맹점번호
		body.add("partner_order_id", request.getPartnerOrderId()); //시리얼 번호가 랜덤으로 나옴(자바 클래스)
		body.add("partner_user_id", request.getPartnerUserId()); //구매자 아이디
		body.add("item_name", request.getItemName()); //구매자 상품명 2개 이상시 외 ?개
		body.add("quantity", "1"); //무조건 1, 수량은 DB에서 관리할거임
		body.add("total_amount", String.valueOf(request.getItemPrice())); //결제금액 개발자용은 100만원이 최대 
		body.add("tax_free_amount", "0"); //면세
		body.add("approval_url", "http://localhost:8080/pay/success");
		body.add("cancel_url", "http://localhost:8080/pay/cancel");
		body.add("fail_url", "http://localhost:8080/pay/fail");
		
		//요청 발송
		HttpEntity entity = new HttpEntity<>(body, headers); //바디+헤더
		
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response ={}", response);
//		log.debug("url = {}", response.get("next_redirect_pc_url"));
	}
}
