package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.MatchDto;

public interface MatchDao {
	
	int sequence();
	void insertMatch(MatchDto matchDto);
	boolean delete(int matchNo);
	boolean update(MatchDto matchDto);
	boolean updateDate(MatchDto matchDto);
	MatchDto selectOne(int matchNo);
	List<MatchDto> selectList();
}
