package com.kh.spring21;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring21.configuration.KakaoPayProperties;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test06Approve {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private HttpHeaders headers;
	
	@Autowired
	private KakaoPayProperties kakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {
		
		//주소
		URI uri = new URI("https://kapi.kakao.com/v1/payment/approve");
		
		//바디
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid",kakaoPayProperties.getCid()); //가맹점 번호
		body.add("tid", "T537690b2b8b1abb00a7"); //거래번호
		body.add("partner_order_id", "1d8f1ecc-f18d-49c4-b113-1f390c73124a"); //가맹점 주문번호
		body.add("partner_user_id", "testuser1"); //가맹점 회원id
		body.add("pg_token", "1e99a0c69471e8de69f1"); //결제승인 요청을 인증하는 토큰
		
		HttpEntity entity = new HttpEntity(body, headers);
		
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}");
	}
}
