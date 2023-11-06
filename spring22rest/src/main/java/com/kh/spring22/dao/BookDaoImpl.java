package com.kh.spring22.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.dto.BookDto;
import com.kh.spring22.error.NoTargetException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BookDto> selectList() {
		return sqlSession.selectList("book.findAll");
	}
	
	@Override
	public BookDto selectOne(int bookId) {
		BookDto bookDto = sqlSession.selectOne("book.findByBookId", bookId);
		if(bookDto == null) throw new NoTargetException();
		return bookDto;
	}
	
	@Override
	public List<BookDto> searchList(String bookTitle) {
		return sqlSession.selectList("book.findByBookTitle", bookTitle);
	}

	@Override
	public void insert(BookDto bookDto) {
		sqlSession.insert("book.save", bookDto);
	}
	
	@Override
	public void edit(int bookId, BookDto bookDto) {
		Map<String, Object> param = Map.of("bookId", bookId, "bookDto", bookDto);
		int result = sqlSession.update("book.change", param);
		if(result == 0) throw new NoTargetException();
	}
	
	@Override
	public void delete(int bookId) {
		int result = sqlSession.delete("book.deleteByBookId", bookId);
		if(result == 0) throw new NoTargetException();
	}
	
}
