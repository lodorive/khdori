package com.kh.springhome.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.springhome.dao.MemberDao;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.vo.PaginationVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberDao memberDao;

	
	@RequestMapping("/home")
	public String home() {
		return "/WEB-INF/views/admin/home.jsp";
	}
	
	@RequestMapping("/member/list")
	public String memberList(@ModelAttribute PaginationVO vo, Model model) {
		
		int count = memberDao.countList(vo); //상황에 맞는 게시글 수
		vo.setCount(count);		
		model.addAttribute("vo",vo); //ModelAttribute(name = "vo")와 같음

		List<MemberDto> list = memberDao.selectListByPage(vo); //상황에 맞는 목록 데이터
		model.addAttribute("list",list);
		
		return "/WEB-INF/views/admin/member/list.jsp";
		
	}
	
	//상세
	@RequestMapping("/member/detail")
	public String memberDetail(@RequestParam String memberId, Model model) {
		//파라미터로 전달된 아이디의 회원정보를 조회하여 모델에 첨부
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/admin/member/detail.jsp";
	}
	
	//수정
	@GetMapping("/member/edit")
	public String memberEdit(HttpSession session, Model model) {
		
		String memberId = (String) session.getAttribute("name");
		MemberDto memberDto = memberDao.selectOne(memberId);
		model.addAttribute("memberDto",memberDto);
		return "/WEB-INF/views/admin/member/edit.jsp";
	}
	
	@PostMapping("/member/edit")
	public String memberEdit(@ModelAttribute MemberDto inputDto,
			HttpSession session) {
		
		String memberId = (String) session.getAttribute("name");
		MemberDto findDto = memberDao.selectOne(memberId);
		return "redirect:detail";
	}
}
