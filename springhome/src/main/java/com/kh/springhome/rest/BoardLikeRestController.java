package com.kh.springhome.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dao.BoardLikeDao;
import com.kh.springhome.dto.BoardLikeDto;

//@CrossOrigin
@RestController
@RequestMapping("/rest/like")
public class BoardLikeRestController {
	
	@Autowired
	private BoardLikeDao boardLikeDao;
	
	//만들어야 하는 기능
	//[1] 좋아요 설정/해제를 수행하는 매핑 - 사용자가 하트 클릭 시 처리
	//[2] 좋아요 상태를 확인하는 매핑 - 사용자 최초 화면에 표시할 하트 확인
	@RequestMapping("/check")
	public String check(@ModelAttribute BoardLikeDto boardLikeDto, HttpSession session) {
		String memberId = (String) session.getAttribute("name");
		boardLikeDto.setMemeberId(memberId);
		
		boolean isCheck = boardLikeDao.check(boardLikeDto);
		return isCheck ? "Y" : "N";
	}
	
	@RequestMapping("/action")
	public String action(@ModelAttribute BoardLikeDto boardLikeDto, HttpSession session) {
		String memberId = (String) session.getAttribute("name");
		boardLikeDto.setMemeberId(memberId);
		
		boolean isCheck = boardLikeDao.check(boardLikeDto);
		if(isCheck) {//체크되어 있다면
			//체크해제
			boardLikeDao.delete(boardLikeDto); //체크해제
			return "N";
		}
		else {//아니라면
			//체크설정
			boardLikeDao.insert(boardLikeDto); //체크설정
			return "Y";
		}
	}
}
