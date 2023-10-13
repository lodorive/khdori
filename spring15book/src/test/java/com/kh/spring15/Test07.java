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
//		param.put("bookId", 2);
//		param.put("bookTitle", "해리포터");
//		param.put("bookAuthor", "제이케이");
//		param.put("bookPublisher", "kh");
//		param.put("bookPriceMin", 10f);
//		param.put("bookPriceMax", 1000f);
//		param.put("bookPublicationBegin", "2023-01-01");
//		param.put("bookPublicationEnd", "2023-12-31");
//		param.put("bookPageMin", 90);
//		param.put("bookPageMax", 500);
//		param.put("bookGenre", "판타지"); //장르가 한개였다면(X)
		param.put("bookGenreList", List.of("판타지", "공포", "교양")); //장르가 여러개라면(O)
		
		List<BookDto> list = sqlSession.selectList("book.complexSearch", param);
		log.debug("검색 결과 = {}", list.size());
		for(BookDto dto:list) {
			log.debug("dto = {}", dto);
		}
	}
	
}
