package jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import jdbc.dto.BoardDto;

public class BoardMapper implements RowMapper<BoardDto>{

	@Override
	public BoardDto mapRow(ResultSet rs, int idx) throws SQLException {
		
		BoardDto dto = new BoardDto();
		dto.setBoardNo(rs.getInt("board_no"));
		dto.setBoardTitle(rs.getString("board_title"));
		dto.setBoardContent(rs.getNString("board_content"));
		dto.setBoardWriter(rs.getNString("board_writer"));
		dto.setBoardReadcount(rs.getInt("board_readcount"));
		return dto;
	}

}
