package com.kh.spring10;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dao.ShirtDao;
import com.kh.spring10.dto.ShirtDto;

@SpringBootTest
public class ShirtListTest {

	@Autowired
	private ShirtDao dao;
	
	@Test
	public void test() {
		List<ShirtDto> list = dao.selectList();
		for(ShirtDto dto : list) {
			System.out.println(dto);
		}
 	}
}
