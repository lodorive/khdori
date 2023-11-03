package com.kh.spring22.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring22.dto.BookDto;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BookDto> selectList() {
		return sqlSession.selectList("book.list");
	}
	
	@Override
	public void insert(BookDto bookDto) {
		sqlSession.insert("book.save", bookDto);
	}
	
	@Override
	public boolean delete(int bookId) {
		return sqlSession.delete("book.remove", bookId) > 0;
	}
	
	@Override
	public BookDto selectOne(int bookId) {
		return sqlSession.selectOne("book.find", bookId);
	}
}
