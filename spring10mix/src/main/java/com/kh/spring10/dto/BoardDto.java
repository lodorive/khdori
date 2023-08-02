package com.kh.spring10.dto;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int boardReadcount;
}
