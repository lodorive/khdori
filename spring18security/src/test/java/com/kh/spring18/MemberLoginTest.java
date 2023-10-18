package com.kh.spring18;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring18.dao.SecureMemberDao;
import com.kh.spring18.dto.SecureMemberDto;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MemberLoginTest {

	@Autowired
	private SecureMemberDao dao;
	
	@Test
	public void test() {
		//로그인 테스트
		SecureMemberDto dto = SecureMemberDto.builder()
				.memberId("testuser1")
				.memberPw("testuser1234")
				.build();
		
		SecureMemberDto target = dao.login(dto);
		log.debug("target = {}", target);
		
		assertNotNull(target); //target이 not null이면 테스트 성공
	}
}
