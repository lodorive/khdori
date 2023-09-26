package com.kh.spring11.dao;


import java.util.List;

import com.kh.spring11.dto.MemberDto;

public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String memberId);
	boolean updateMemberLogin(String memberId);
	boolean updateMemberPw(String memberId, String changePw);
	boolean updateMemberInfo(MemberDto memberDto);
	boolean delete(String memberId);
	List<MemberDto> selectList();
	
	boolean updateMemberInfoByAdmin(MemberDto memberDto);

	//차단+해제 기능
	void insertBlock(String memberId);
	boolean deleteBlock(String memberId);
	
	
	MemberDto selectOneByMemberNickname(String memberNick);


}
