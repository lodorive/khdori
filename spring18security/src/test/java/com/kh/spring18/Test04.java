package com.kh.spring18;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Test04 {

	@Test
	public void test() {
		//spring-security에서 제공하는 라이브러리를 사용하여 암호화를 진행(bcrypt)
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String origin = "hello";
		String encrypt = encoder.encode(origin);
		
		log.debug("origin = {}", origin);
		log.debug("encrypt = {}", encrypt);
		
		//주의할 점은 매번 암호화 결과가 달라지기 때문에 라이브러리를 통해서만 비교가 가능하다
		
		String input = "hello";
		boolean result = encoder.matches(input, encrypt); //순서 바뀌면 실행이 안된다
		//(왼쪽이 비교할 신규 입력값, 오른쪽이 기존의 암호화된 값)
		log.debug("result = {}", result);
		assertTrue(result); //result가 true라면 테스트 성공 아니면 실패
	}
}
