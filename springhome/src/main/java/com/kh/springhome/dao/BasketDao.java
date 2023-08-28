package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BasketDto;

public interface BasketDao {
	void insert(BasketDto basketDto);
	List<BasketDto> selectList();
	BasketDto selectOne(int basketNo);
	boolean update(BasketDto basketDto);
	boolean delete(int basketNo);	
}
