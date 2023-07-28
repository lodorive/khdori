package com.kh.spring06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring06.dao.BoardDao;
import com.kh.spring06.dto.BoardDto;

@RestController
public class BoardController {
	
	@Autowired
	private BoardDao dao;
	
	//등록
	@RequestMapping("/insert")
	public String insert(
			@ModelAttribute BoardDto dto) {
		dao.insert(dto);
		return "게시글 등록 완료";
	}
	
	//수정
	@RequestMapping("/update")
	public String update(
			@ModelAttribute BoardDto dto) {		
		if(dao.update(dto)) {
			return "게시글 정보가 수정되었습니다";
		}
		else{
			return "해당 게시글 번호는 존재하지 않습니다";
		}
	}
	
	//삭제
	@RequestMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		if(dao.delete(boardNo)) {
			return "게시글 정보를 삭제 완료";
		}
		else {
			return "해당 게시글 번호가 존재하지 않음";
		}
	}
	
	//목록
	@RequestMapping("/list")
	public String list() {
		List<BoardDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(BoardDto dto : list) {
			buffer.append("[");
			buffer.append(dto.getBoardNo());
			buffer.append("]");
			buffer.append(dto.getBoardTitle());
		}
		return buffer.toString();
	}
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam int boardNo) {
		BoardDto dto = dao.selectOne(boardNo);
		if(dto == null) {
			return "존재하지 않는 게시글";
		}
		else {
			//return dto.toString();
			StringBuffer buffer = new StringBuffer();
			buffer.append("[제목]"+dto.getBoardTitle());
			buffer.append("("+dto.getBoardWriter()+")");
			buffer.append("<br>");
			buffer.append("---------------------------");
			buffer.append("<br>");
			buffer.append(dto.getBoardContent());
			buffer.append("<br>");
			return buffer.toString();
		}
	}
}
