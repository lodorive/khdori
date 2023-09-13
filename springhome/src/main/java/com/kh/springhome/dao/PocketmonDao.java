package com.kh.springhome.dao;

import com.kh.springhome.dto.PocketmonDto;

public interface PocketmonDao {
	int sequence();
	void insert(PocketmonDto pocketmonDto);
}
