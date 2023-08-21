package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.vo.PaginationVO;

//메소드 명세만 작성(책으로치면 목차)
public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String memberId);
	boolean updateMemberLogin(String memberId);
	boolean updateMemberPw(String memberId, String changePw);
	boolean updateMemberInfo(MemberDto memberDto);
	boolean deleteMember(String memberId);
	
	boolean increaseMemberPoint(String memberId, int point);
//	boolean decreaseMemberPoint(String memberId);
	
	List<MemberDto> selectListByPage(PaginationVO vo);
	int countList(PaginationVO vo);
}
