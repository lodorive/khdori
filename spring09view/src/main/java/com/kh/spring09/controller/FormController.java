package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	@RequestMapping("/form") //공용 주소

		//포켓몬 등록
	public class FormController {
		@RequestMapping("/test01")
		public String test01() {
			return "/WEB-INF/views/form/test01.jsp";
		}
	
		//게시글 작성
	@RequestMapping("/test02")
		public String test02() {
			return "/WEB-INF/views/form/test02.jsp";
		}
	
		//도서 등록
	@RequestMapping("/test03")
		public String test03() {
			return "/WEB-INF/views/form/test03.jsp";
	}
	
		//회원 가입
	@RequestMapping("/test04")
		public String test04() {
			return "/WEB-INF/views/form/test04.jsp";
	}
}
