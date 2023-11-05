package com.kh.spring20.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring20.dto.ClubDto;

@Repository
public class ClubDaoImpl implements ClubDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(ClubDto dto) {
		sqlSession.insert("club.add", dto);
		
	}
	
	@Override
	public List<ClubDto> list() {
		return sqlSession.selectList("club.list");
	}

}
