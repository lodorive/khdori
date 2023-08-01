package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form2")
public class FormController2 {
	
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/form2/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/form2/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return "/WEB-INF/views/form2/test03.jsp";
		
	}
}
