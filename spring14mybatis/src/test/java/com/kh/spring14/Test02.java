package com.kh.spring14;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		//구문에 필요한 값이 있다면 만들어서 전달하며 불러야 한다
		int no = 16;
		PocketmonDto dto = sqlSession.selectOne("pocketmon.find", no);
		log.debug("dto = {}", dto);
	}	
}
