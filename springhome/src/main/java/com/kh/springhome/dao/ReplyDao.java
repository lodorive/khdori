package com.kh.springhome.dao;

import com.kh.springhome.dto.ReplyDto;

public interface ReplyDao {
	int sequence();
	void insert(ReplyDto replyDto);
}
