package com.kh.spring07.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring07.dao.BookDao;
import com.kh.spring07.dto.BookDto;

@RestController
public class BookController {
	
	@Autowired
	private BookDao dao;
	
	//등록
	@RequestMapping("/save")
	public String save(
			@ModelAttribute BookDto dto){
		dao.insert(dto);
		return "도서 등록 완료";
	}
	
	//변경
	@RequestMapping("/edit")
	public String edit(
			@ModelAttribute BookDto dto) {
		if(dao.update(dto)) {
			return "도서 정보가 수정되었습니다";
		}
		else {
			return "찾으시는 도서 번호가 없습니다";
		}
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int bookId) {
		if(dao.delete(bookId)) {
			return "도서 정보가 삭제되었습니다";
		}
		else {
			return "찾으시는 도서 번호가 없습니다";
		}
	}
	//목록 조회
	@RequestMapping("/list")
	public String list() {
		List<BookDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(BookDto dto : list) {
			buffer.append(dto);
		}
		return buffer.toString();
	}
	
	//상세 조회
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId) {
		BookDto dto = dao.selectOne(bookId);
		if(dto == null) {
			return "존재하지 않는 도서입니다";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("제목 : [");
			buffer.append(dto.getBookTitle());
			buffer.append("]");
			buffer.append("<br>");
			buffer.append("저자 : "+dto.getBookAuthor());
			buffer.append("<br>");
			buffer.append("가격 : $"+dto.getBookPrice());
			return buffer.toString();
		}
	}
	
}
