package com.kh.spring15.dao;

import java.util.List;

import com.kh.spring15.dto.BookDto;
import com.kh.spring15.vo.BookComplexSearchVO;

public interface BookDao {
	List<BookDto> complexSearch(BookComplexSearchVO vo);
}
