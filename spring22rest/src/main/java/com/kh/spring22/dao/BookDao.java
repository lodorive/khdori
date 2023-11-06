package com.kh.spring22.dao;

import java.util.List;

import com.kh.spring22.dto.BookDto;

public interface BookDao{
	List<BookDto> selectList();
	BookDto selectOne(int bookId);
	List<BookDto> searchList(String bookTitle);
	void insert(BookDto bookDto);
	void edit(int bookId, BookDto bookDto);
	boolean delete(int bookId);
}
