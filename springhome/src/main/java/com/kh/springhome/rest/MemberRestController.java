package com.kh.springhome.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dao.MemberDao;

@CrossOrigin
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {

	@Autowired
	private MemberDao memberDao;
	
	//아이디 중복검사
		@PostMapping("/idCheck")
		public String idCheck(@RequestParam String memberId) {
			MemberDto memberDto = memberDao.selectOne(memberId);
			if(memberDto == null) {//아이디가 없으면
				return "Y";
			}
			else {//아이디가 있으면
				return "N";
			}
		}
		
		//닉네임 중복검사
		@PostMapping("/nicknameCheck")
		public String nicknameCheck(@RequestParam String memberNickname) {
			MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
			if(memberDto == null) {
				return "Y"; //닉네임 사용 가능
			}
			else {
				return "N"; //닉네임 이미 있음
			}
		}
	
}
