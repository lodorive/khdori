package com.kh.spring08.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.kh.spring08.dao.MemberDao;
import com.kh.spring08.dto.MemberDto;

@RestController
@RequestMapping("/member")//공용주소
public class MemberController {

	@Autowired
	private MemberDao dao;
	
	//등록
	@RequestMapping("/join")
	public String join(
			@ModelAttribute MemberDto dto) {
		dao.insert(dto);
		return "회원 등록 완료";
	}
	//목록
	@RequestMapping("/list")
	public String list() {
		List<MemberDto> list = dao.selectList();
		StringBuffer buffer = new StringBuffer();
		for(MemberDto dto : list) {
			buffer.append(dto);
		}
		return buffer.toString();
	}
	
	//상세
	@RequestMapping("/detail")
	public String detail(@RequestParam String memberId) {
		MemberDto dto = dao.selectOne(memberId);
		if(dto == null) {
			return "찾으시는 회원 정보가 없습니다";
		}
		else {
			StringBuffer buffer = new StringBuffer();
			buffer.append("아이디 : "+dto.getMemberId());
			buffer.append("<br>");
			buffer.append("닉네임 : "+dto.getMemberNickname());
			return buffer.toString();
		}		
	}
		//비밀번호 변경
		//비밀번호를 변경할 때는 아이디, 바꿀 비밀번호만 있으면 된다
		//하지만, 여러가지 확인을 위해 추가정보를 요구할 수도 있다
		//(ex) 기존 비밀번호(o), 비밀번호확인(x)
	
		//테스트 주소 - http://localhost:8080/member/password?memberId=?&membrPw=?&changePw=?
		@RequestMapping("/password")
		public String password(
				@RequestParam String memberId,//아이디
				@RequestParam String memberPw,//기존비번
				@RequestParam String changePw) {//바꿀비번
			//일단 아이디로 회원정보를 불러온다
			MemberDto origindDto = dao.selectOne(memberId);
			if(origindDto == null) {
				return "존재하지 않는 아이디";
			}
			if(origindDto.getMemberPw().equals(memberPw)) { //비밀번호가 일치한다면
				MemberDto changeDto = new MemberDto();
				changeDto.setMemberId(memberId);
				changeDto.setMemberPw(memberPw);
				boolean result = dao.updateMemberPw(changeDto);		
							return "변경 완료";
						}
						else {
							return "비밀번호가 일치하지 않습니다";
					}	
				}
		
		//개인정보 변경 시 비밀번호를 추가로 전달받아 검사 후 변경
		@RequestMapping("/change")
		public String change(@ModelAttribute MemberDto changeDto) {
			//비밀번호 검사를 위한 정보 조회
			MemberDto originDto = dao.selectOne(changeDto.getMemberId());
			if(originDto == null) {
				return "아이디 없음";
			}
			if(originDto.getMemberPw().equals(changeDto.getMemberPw()) == false) {
				return "비밀번호 일치하지 않음";
			}
			
			//다 통과한 경우
			dao.update(changeDto);
			return "변경 완료";
			}
		
		//삭제
		//회원은 탈퇴 시에도 비밀번호를 검사해야 한다
		@RequestMapping("/exit")
		public String exit(@ModelAttribute MemberDto inputDto ) {
			MemberDto originDto = dao.selectOne(inputDto.getMemberId());
			if(originDto == null) {
				return "아이디 없음";
			}
			if(originDto.getMemberPw().equals(inputDto.getMemberPw()) == false) {
				return "비밀번호 맞지 않음";
			}
			dao.delete(inputDto.getMemberId());
			return "안녕히가세요";
		}
	}

