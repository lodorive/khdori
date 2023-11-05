package com.kh.spring20.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring20.dto.ChatRoomDto;
import com.kh.spring20.dto.ClubDto;
import com.kh.spring20.dto.MemberDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class WebSocketViewController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/default")
	public String defaultServer() {
		return "default";
	}
	
	@RequestMapping("/time")
	public String time() {
		return "time";
	}
	
	@RequestMapping("/group")
	public String group() {
		return "group";
	}
	
	//임시 로그인 처리	
	@Autowired
	private SqlSession sqlSession;
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
	    MemberDto findDto = sqlSession.selectOne("member.find", memberDto);
	    
	    if (findDto != null) { // 아이디가 있으면
	        boolean pwMatch = findDto.getMemberPw().equals(memberDto.getMemberPw());
	        if (pwMatch) {
	            session.setAttribute("name", findDto.getMemberId()); // 아이디
	            session.setAttribute("level", findDto.getMemberLevel()); // 등급
	            session.setAttribute("nickname", findDto.getMemberNickname()); // 닉네임
	            
	            // 사용자와 관련된 동호회 및 채팅 룸 정보 조회
	            String memberId = findDto.getMemberId();
	            
	            // 동호회 정보 조회
	            ClubDto clubFindDto = sqlSession.selectOne("club.find", memberId);
                log.debug("Club Info: {}", clubFindDto);
                
             // 채팅 룸 정보 조회
                ChatRoomDto roomFindDto = sqlSession.selectOne("chatRoom.find", memberId);
                log.debug("Room Info: {}", roomFindDto);
                
                if (roomFindDto != null) { //채팅방 번호가 있다면
	                session.setAttribute("chatRoomNo", roomFindDto.getChatRoomNo()); // 채팅방 번호를 넣고
	            }
	            
	            if (clubFindDto != null) { //동호회 번호가 있으면
	                session.setAttribute("clubNo", clubFindDto.getClubNo()); // 동호회 번호를 넣어라
	            }
	        }
	    }

	    return "redirect:/";
	}

	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("level");
		session.removeAttribute("nickname");
		return "redirect:/";
	}
	
	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/json")
	public String json() {
		return "json";
	}
	
	@RequestMapping("/sockjs")
	public String sockjs() {
		return "sockjs2";
	}
	
	@GetMapping("/sockjs/clubNo={clubNo}")
	public String getSockJSPage(@PathVariable int clubNo, Model model, HttpSession session) {
	   

	       return "sockjs2"; // 클럽 멤버용 페이지로 이동
	}
}
