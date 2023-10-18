package com.kh.spring16;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring16.dto.CustomerDto;

@SpringBootTest
public class Test05 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {		
		sqlSession.update("customer.edit", CustomerDto.builder()
				.customerId("testuser423")
				.customerContact("010-4444-6666")
				.customerJoin("2023-10-12")
				.customerPurchase("2024-12-31")
				.customerMileage(3500)
				.customerLevel("VIP")
				.customerNo(3)
				.build());
	}
}
