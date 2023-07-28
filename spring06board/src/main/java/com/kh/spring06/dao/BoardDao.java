package com.kh.spring06.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring06.dto.BoardDto;
import com.kh.spring06.mapper.BoardDetailMapper;
import com.kh.spring06.mapper.BoardListMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	private BoardDetailMapper detailmapper;
	
	@Autowired
	private BoardListMapper listMapper;
	
	public void insert(BoardDto dto) {
		String sql = "insert into board(board_no, board_title, board_content, "
						+ "board_writer, board_readcount) "
						+ "values(board_seq.nextval,?,?,?,0)";
		Object[] data = {dto.getBoardTitle(), dto.getBoardContent(),
							dto.getBoardWriter()};
		jdbctemplate.update(sql, data);
	}
	
	//수정 기능
	public boolean update(BoardDto dto) {
		String sql = "update board set board_title=?, board_content=? "
				+ "where board_no=?";
		Object[] data = {dto.getBoardTitle(), dto.getBoardContent(),
								dto.getBoardNo()};
		return jdbctemplate.update(sql, data) > 0;
	}

	public boolean delete(int boardNo) {
		String sql = "delete board where board_no=?";
		Object[] data = {boardNo};
		return jdbctemplate.update(sql, data) >0;
	}
	
	//조회 기능
	public List<BoardDto> selectList(){
		//String sql = "select * from board order by board_no desc";
		String sql = "select board_no, board_title, board_writer, board_readcount "
				+ "from board order by board_no desc";
		return jdbctemplate.query(sql, listMapper);
	}
	
	//조회(상세) 기능
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no=?";
		Object[] data = {boardNo};
		List<BoardDto> list = jdbctemplate.query(sql, detailmapper, data);
		return list.isEmpty() ? null : list.get(0);
	}
}
