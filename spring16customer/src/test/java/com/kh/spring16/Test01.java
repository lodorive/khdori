package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.CustomerDto;

@SpringBootTest
public class Test01 {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		
		sqlSession.insert("customer.add", CustomerDto.builder()
				.customerId("testuser1")
				.customerContact("010-4442-1365")
				.customerJoin("2021-01-01")
				.customerPurchase("2021-03-03")
				.customerMileage(5200)
				.customerLevel("플래티넘")
				.build());
	}
}
