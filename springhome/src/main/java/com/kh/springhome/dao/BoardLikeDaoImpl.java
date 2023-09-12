package com.kh.springhome.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.springhome.dto.BoardLikeDto;
import com.kh.springhome.mapper.BoardLikeMapper;

@Repository
public class BoardLikeDaoImpl implements BoardLikeDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardLikeMapper boardLikeMapper;
	
	@Override
	public void insert(BoardLikeDto boardLikeDto) {		
		String sql = "insert into board_like(member_id, board_no) values(?,?)";
		Object[] data = {boardLikeDto.getMemeberId(), boardLikeDto.getBoardNo()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public boolean delete(BoardLikeDto boardLikeDto) {
		String sql = "delete board_like where member_id=? and board_no=?"; //복합키라서 조건 2개
		Object[] data = {boardLikeDto.getMemeberId(), boardLikeDto.getBoardNo()};
		return jdbcTemplate.update(sql, data) > 0;
	}

	@Override
	public boolean check(BoardLikeDto boardLikeDto) {
		String sql = "select * from board_like where member_id=? and board_no=?";
		Object[] data = {boardLikeDto.getMemeberId(), boardLikeDto.getBoardNo()};
		List<BoardLikeDto> list = jdbcTemplate.query(sql, boardLikeMapper, data);
		return list.isEmpty() ? false : true; 
	}

}
