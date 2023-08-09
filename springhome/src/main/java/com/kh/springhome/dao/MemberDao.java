package com.kh.springhome.dao;

import com.kh.springhome.dto.MemberDto;

//메소드 명세만 작성(책으로치면 목차)
public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String memberId);
	boolean updateMemberLogin(String memberId);
	boolean updateMemberPw(String memberId, String changePw);
	boolean updateMemberInfo(MemberDto memberDto);
}
