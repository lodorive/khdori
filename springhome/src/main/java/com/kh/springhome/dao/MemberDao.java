package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.MemberBlockDto;
import com.kh.springhome.dto.MemberDto;
import com.kh.springhome.dto.MemberListDto;
import com.kh.springhome.dto.StatDto;
import com.kh.springhome.vo.PaginationVO;

//메소드 명세만 작성(책으로치면 목차)
public interface MemberDao {
	void insert(MemberDto memberDto);
	MemberDto selectOne(String memberId);
	boolean updateMemberLogin(String memberId);
	boolean updateMemberPw(String memberId, String changePw);
	boolean updateMemberInfo(MemberDto memberDto);
	boolean updateMemberInfoByAdmin(MemberDto memberDto);
	boolean deleteMember(String memberId);
	
	boolean increaseMemberPoint(String memberId, int point);
//	boolean decreaseMemberPoint(String memberId);
	
	List<MemberDto> selectListByPage(PaginationVO vo);
	List<MemberListDto> selectListByPage2(PaginationVO vo);
	int countList(PaginationVO vo);
	
	//차단+해제 기능
	void insertBlock(String memberId);
	boolean deleteBlock(String memberId);
	
	List<MemberBlockDto> selectBlockList();
	MemberBlockDto selectBlockOne(String memberId);
	
	//닉네임 중복 검사
	MemberDto selectOneByMemberNickname(String memberNickname);
	
	//통계 기능 추가
	List<StatDto> selectGroupByMemberLevel();
	
	//프로필 관련 기능
	void insertProfile(String memberId, int attachNo);
	boolean deleteProfile(String memberId);
	Integer findProfile(String memberId);
}
