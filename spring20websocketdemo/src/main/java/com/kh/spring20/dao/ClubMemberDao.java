package com.kh.spring20.dao;

import java.util.List;

import com.kh.spring20.dto.ClubMemberDto;

public interface ClubMemberDao {
	
	void insert(ClubMemberDto dto);
	List<ClubMemberDto> list();

}
