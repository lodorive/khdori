package com.kh.spring20.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring20.dto.ClubMemberDto;

@Repository
public class ClubMemberDaoImpl implements ClubMemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(ClubMemberDto dto) {
		sqlSession.insert("clubMember.add", dto);
	}
	
	@Override
	public List<ClubMemberDto> list() {
		return sqlSession.selectList("clubMember.list");
	}
}
