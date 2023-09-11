package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.ReplyDto;

public interface ReplyDao {
	int sequence();
	void insert(ReplyDto replyDto);
	
	List<ReplyDto> selectList(int replyOrigin);
	ReplyDto selectOne(int replyNo);
}
