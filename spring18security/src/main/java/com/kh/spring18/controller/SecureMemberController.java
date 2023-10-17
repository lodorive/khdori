package com.kh.spring18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring18.dao.SecureMemberDao;
import com.kh.spring18.dto.SecureMemberDto;

@Controller
@RequestMapping("/secure")
public class SecureMemberController {

	@Autowired
	private SecureMemberDao dao;

	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/secure/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute SecureMemberDto dto) {
		dao.insert(dto);
		return "redirect:joinFinish";
	}
	
	@GetMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/secure/joinFinish.jsp";
	}
}
