package com.kh.spring15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test07 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();	
		param.put("bookId", 2);
		
		List<BookDto> list = sqlSession.selectList("book.complexSearch", param);
		log.debug("검색 결과 = {}", list.size());
		for(BookDto dto:list) {
			log.debug("dto = {}", dto);
		}
	}
	
}
