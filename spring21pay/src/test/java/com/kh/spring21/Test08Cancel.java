package com.kh.spring21;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring21.service.KakaoPayService;
import com.kh.spring21.vo.KakaoPayCancelRequestVO;
import com.kh.spring21.vo.KakaoPayCancelResponseVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test08Cancel {
	
	@Autowired
	private KakaoPayService kakaoPayService;
	
	@Test
	public void test() throws URISyntaxException {
		KakaoPayCancelRequestVO request = KakaoPayCancelRequestVO.builder()
				.tid("T538a03b2b8b1abb1019")
				.cancelAmount(200000)
			.build();
		
		KakaoPayCancelResponseVO response = kakaoPayService.cancel(request);
		log.debug("response = {}", response);
	}
}
