package com.kh.spring20.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ChatDto {
	
	private int chatNo;
	private String chatSender, chatSenderLevel, chatSenderNickname, chatReceiver;
	private int chatRoomNo, clubNo;
	private String chatContent;
	private Date chatTime;
	
}
