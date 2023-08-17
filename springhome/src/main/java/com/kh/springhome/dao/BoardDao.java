package com.kh.springhome.dao;

import java.util.List;

import com.kh.springhome.dto.BoardDto;

public interface BoardDao {
	int sequence();
	void insert(BoardDto boardDto); 
	BoardDto selectOne(int boardNo);
	List<BoardDto> selectList();
	boolean updateBoard(BoardDto boardDto);
	boolean deleteBoard(int boardNo);
	
	boolean updateBoardReadcount(int boardNo);
	boolean updateBoardUtime(int boardNo);
	Integer selectMax(String boardWriter);
}
