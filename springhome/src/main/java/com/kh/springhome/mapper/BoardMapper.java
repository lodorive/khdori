package com.kh.springhome.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.springhome.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto>{

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setBoardWriter(rs.getString("board_writer"));
		boardDto.setBoardTitle(rs.getString("board_title"));
		boardDto.setBoardContent(rs.getString("board_content"));
		boardDto.setBoardReadcount(rs.getInt("board_readcount"));
		boardDto.setBoardLikecount(rs.getInt("board_likecount"));
		boardDto.setBoardReplycount(rs.getInt("board_replycount"));
		boardDto.setBoardCtime(rs.getDate("board_ctime"));
		boardDto.setBoardUtime(rs.getDate("board_utime"));
		return boardDto;
	}

	
}
