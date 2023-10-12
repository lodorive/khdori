package com.kh.spring15;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring15.dto.BookDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		sqlSession.update("book.edit", BookDto.builder()
				.bookTitle("바꾼제목")
				.bookAuthor("바꾼작가")
				.bookPrice(88.88f)
				.bookPageCount(88)
				.bookPublicationDate("2033-10-12")
				.bookPublisher("바꾼출판사")
				.bookGenre("교양")
				.bookId(3)
				.build());
	}
}
