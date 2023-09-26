package com.kh.spring11.dao;

import java.util.List;

import com.kh.spring11.dto.StadiumDto;

public interface StadiumDao {
	
	void insert(StadiumDto stadiumDto);
	int sequenceStadium();
	StadiumDto selectOne(int stadiumNo);
	List<StadiumDto> selectList();

}
