package com.kh.spring12.dao;

import com.kh.spring12.dto.AttachDto;

public interface AttachDao {
	int sequence();
	void insert(AttachDto attachDto);
	AttachDto selectOne(int attachNo);
}
