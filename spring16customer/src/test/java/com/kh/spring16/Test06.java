package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test06 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		int customerNo = 1;
		sqlSession.delete("customer.del", customerNo);
	}
}
