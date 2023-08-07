package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.BoardDao;
import com.kh.spring10.dto.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDao dao;
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo, Model model) {
		BoardDto dto = dao.selectOne(boardNo);
		model.addAttribute("dto", dto);
		return "/WEB-INF/views/board/detail.jsp";				
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<BoardDto> list = dao.selectList();
		model.addAttribute("list", list);
		return "/WEB-INF/views/board/list.jsp";	
	}
	
	@GetMapping("/write")
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDto dto) {
		int boardNo = dao.sequence(); //번호를 구해서
		dto.setBoardNo(boardNo); //dto에 추가하고
		dao.insert(dto); //등록
		//방금 등록한 번호의 게시글 상세 페이지로 강제 이동(redirect)
		return "redirect:detail?boardNo="+boardNo;
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam int boardNo, Model model) {
		BoardDto dto = dao.selectOne(boardNo);
		model.addAttribute("dto",dto);
		return "/WEB-INF/views/board/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto dto) {
		boolean result = dao.update(dto);
		if(result) {
			return "redirect:detail?boardNo="+dto.getBoardNo();
		}
		else {
			return "redirect:에러페이지주소";
		}
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boolean result = dao.delete(boardNo);
		if(result) {
			return "redirect:list";
		}
		else {
			return "redirect:에러페이지";
		}
	}
	
	//경로변수
	//- 경로 중간에 변수로 사용할 영역을 지정하는 방식
	//- 주소를 간단하게 만들기 위해서 사용
	//- 전달할 값이 많으면 안쓰는게 좋다
	//- @PathVariable로 처리하며 [경로의 끝지점(endpoint)]이 달라진다
	
	@RequestMapping("/delete/{boardNo}")
	public String delete2(@PathVariable int boardNo) {
		boolean result = dao.delete(boardNo);
		if(result) {
			//return "redirect:../list";
			return "redirect:/board/list";
		}
		else {
			return "redirect:에러페이지";
		}
	}
}

