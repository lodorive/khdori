package com.kh.springhome.controller;

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

//회원 관련 기능을 처리하는 컨트롤러
@Controller
@RequestMapping("/member")
public class MemberController {
	//Autowired는 지정한 클래스 및 자식 클래스 중에서 등록된 것을 찾아 주입한다
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
		return "/WEB-INF/views/member/join.jsp";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:joinFinish";//상대경로
		//return "redirect:/member/joinFinish"; //절대경로
	}
	@RequestMapping("/joinFinish")
	public String joinFinish() {
		return "/WEB-INF/views/member/joinFinish.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/WEB-INF/views/member/login.jsp";
	}
	
	/**
	 	로그인과 같이 사용자별로 관리되어야 하는 상태정보들이 있다
	 	이때 사용할 수 있는 저장소로 HttpSession이 있다
	 	이 저장소는 사용자별로 정보가 따로 저장되며, 외부에서 접근 불가능하다
	 	컨트롤러에 선언만 하면 사용할 수 있으며, key=value 형태로 저장된다
	 	
	 	[1] 추가 - session.setAttribute("key", value);
	 	[2] 확인 - session.getAttribute("key");
	 	[3] 삭제 - session.removeAttribute("key");
	 */
	
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDto inputDto, HttpSession session) {
		//[1] 사용자가 입력한 아이디로 데이터베이스에서 정보를 조회
		MemberDto findDto = memberDao.selectOne(inputDto.getMemberId());
		//[2] 1번에서 정보가 있다면 비밀번호를 검사(없으면 차단)
		if(findDto == null) {
			return "redirect:login?error"; //redirect는 무조건 GetMapping으로 간다
		}
		//입력한 비밀번호와 DB번호가 같나?
		boolean isCorrectPw = inputDto.getMemberPw().equals(findDto.getMemberPw());
		
		//[3] 비밀번호가 일치하면 메인페이지로 이동(로그인에 성공했을 때)
		if(isCorrectPw) {
			//세션에 아이디 저장
			session.setAttribute("name", inputDto.getMemberId());
			//로그인시간 갱신
			memberDao.updateMemberLogin(inputDto.getMemberId());
			//메인페이지로 이동
			return "redirect:/"; 
		}
		//[4] 비밀번호가 일치하지 않으면 로그인페이지로 이동
		else {
			return "redirect:login?error";
		}
	}
	
	//--------------회원 전용 메뉴--------------
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("name");
		return "redirect:/";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, Model model) {
		//[1] 세션에서 사용자의 아이디를 꺼낸다
		//- 세션은 값을 Object로 저장한다(아무거나 넣어야 하니까)
		String memberId = (String) session.getAttribute("name");
		//[2] 가져온 아이디로 회원정보를 조회한다
		MemberDto memberDto = memberDao.selectOne(memberId);
		//[3] 조회한 정보를 모델에 첨부한다
		model.addAttribute("memberDto",memberDto);
		return "/WEB-INF/views/member/mypage.jsp";
	}
	
	//비밀번호 변경
	@GetMapping("/password")
	public String password() {
		return "/WEB-INF/views/member/password.jsp";
	}
		
	@PostMapping("/password")
	public String password(HttpSession session, 
								@RequestParam String originPw,
								@RequestParam String changePw) {
		String memberId = (String) session.getAttribute("name");
		MemberDto memberDto = memberDao.selectOne(memberId);

		//[1] 기존 비밀번호가 일치하는지 판정
		if(memberDto.getMemberPw().equals(originPw)) {//비밀번호가 일치한다면
			//[2] 1번이 성공일 때만 비밀번호를 변경하도록 처리(+개인정보 변경시각 수정)
			memberDao.updateMemberPw(memberId, changePw);
			return "redirect:passwordFinish";
		}
		else {
			return "redirect:password?error";
		}
	}

		@RequestMapping("/passwordFinish")
	public String passwordFinish() {
		return "/WEB-INF/views/member/passwordFinish.jsp";
	}
}