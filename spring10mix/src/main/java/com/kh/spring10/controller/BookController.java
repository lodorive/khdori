package com.kh.spring10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BookDao;
import com.kh.spring10.dto.BookDto;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookDao dao;
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int bookId, Model model) {
		BookDto dto = dao.selectOne(bookId);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/book/detail.jsp";
	}
}
