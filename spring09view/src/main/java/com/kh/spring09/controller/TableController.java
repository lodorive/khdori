package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/table")
public class TableController {

	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/table/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/table/test02.jsp";
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return "/WEB-INF/views/table/test03.jsp";
	}
	
	@RequestMapping("/test04")
	public String test04() {
		return "/WEB-INF/views/table/test04.jsp";
	}
}
