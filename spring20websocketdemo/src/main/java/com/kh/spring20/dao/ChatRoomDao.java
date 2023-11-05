package com.kh.spring20.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kh.spring20.dto.ChatRoomDto;

@Repository
public interface ChatRoomDao {
	
	void insert(ChatRoomDto dto);
	List<ChatRoomDto> list();

}
