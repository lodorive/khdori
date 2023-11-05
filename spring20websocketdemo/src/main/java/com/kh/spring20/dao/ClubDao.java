package com.kh.spring20.dao;

import java.util.List;

import com.kh.spring20.dto.ClubDto;

public interface ClubDao {
	void insert(ClubDto dto);
	List<ClubDto> list();
	
}
