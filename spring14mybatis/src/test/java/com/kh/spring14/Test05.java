package com.kh.spring14;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test05 {

	@Autowired
	SqlSession sqlSession;	
	
	@Test
	public void test() {
		int no = 41;
		int count = sqlSession.delete("pocketmon.del", no);
		boolean result = count > 0;
		log.debug("result = {}", result);
	}
}

