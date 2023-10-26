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
public class Test07Detail {
	@Autowired
	RestTemplate template;
	
	@Autowired
	HttpHeaders headers;
	
	@Autowired
	KakaoPayProperties kakaoPayProperties;
	
	@Test
	public void test() throws URISyntaxException {		
		//조회 주소
		URI uri = new URI("https://kapi.kakao.com/v1/payment/order");
		
		//바디
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("cid", kakaoPayProperties.getCid());
		body.add("tid", "T53875db51b66fd4083c");
		
		//요청 발송
		HttpEntity entity = new HttpEntity(body, headers);
		
		Map response = template.postForObject(uri, entity, Map.class);
		log.debug("response = {}", response);
	}
}
