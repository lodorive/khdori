package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

@SpringBootTest
public class Test01 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
//		BookDto dto = new BookDto();
//		dto.setBookTitle("어린왕자");
//		dto.setBookAuthor("도리제인");
//		dto.setBookPublicationDate("2021-07-26");
//		dto.setBookPrice(59.99f);
//		dto.setBookPublisher("dorihouse");
//		dto.setBookPageCount(420);
//		dto.setBookGenre("Fantasy");
		
//		BookDto dto = BookDto.builder().bookTitle("테스트서적").build();

		sqlSession.insert("book.add", BookDto.builder()
				.bookTitle("테스트서적")
				.bookAuthor("테스트작가")
				.bookPublicationDate("2011-08-28")
				.bookPrice(12.22f)
				.bookPublisher("khacademy")
				.bookPageCount(220)
				.bookGenre("공포")
				.build());
	}
}
