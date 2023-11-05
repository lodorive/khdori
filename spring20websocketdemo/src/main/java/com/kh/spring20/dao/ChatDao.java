package com.kh.spring20.dao;

import java.util.List;
import java.util.Map;

import com.kh.spring20.dto.ChatDto;

public interface ChatDao {
	void insert(ChatDto dto);
	List<ChatDto> list();
	List<ChatDto> selectList(String memberId);
	

	}
