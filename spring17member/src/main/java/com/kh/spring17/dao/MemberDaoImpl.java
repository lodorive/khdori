package com.kh.spring17.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring17.dto.MemberDto;
import com.kh.spring17.vo.MemberComplexSearchVO;

@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberDto> complexSearch(MemberComplexSearchVO vo){
		List<MemberDto> list = sqlSession.selectList("member.complexSearch", vo);
		return list;
	}
}
