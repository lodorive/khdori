package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dao.ShirtDao;

@SpringBootTest
public class ShirtDeleteTest {
	
	@Autowired
	private ShirtDao dao;
	
	@Test
	public void test() {
		int shirtNo = 999;
		boolean resutl = dao.delete(shirtNo);
		System.out.println("result = "+resutl);
	}
}
