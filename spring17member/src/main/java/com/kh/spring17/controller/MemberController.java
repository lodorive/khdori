package com.kh.spring17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring17.dao.MemberDao;
import com.kh.spring17.vo.MemberComplexSearchVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("/list")
	public String list(@ModelAttribute("vo") MemberComplexSearchVO vo, Model model) {
		model.addAttribute("list", memberDao.complexSearch(vo));
		return "/WEB-INF/views/member/list.jsp";
	}

}
