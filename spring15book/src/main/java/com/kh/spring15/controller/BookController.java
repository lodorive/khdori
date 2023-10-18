package com.kh.spring15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring15.dao.BookDao;
import com.kh.spring15.vo.BookComplexSearchVO;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookDao bookDao;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("vo") BookComplexSearchVO vo, Model model) {
		model.addAttribute("list", bookDao.complexSearch(vo));
		return "/WEB-INF/views/book/list.jsp";
	}
}
