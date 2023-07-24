package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BoardDto;
import jdbc.mapper.BoardMapper;
import jdbc.util.JdbcUtils;

public class Test03_1 {
	public static void main(String[] args) {
		//Board 검색
		//- 준비물 : BoardDto, BoardMapper
		
		String keyword = "테스트";
		String sql = "select * from board where instr(board_title, ?)>0 order by board_no desc";
		Object[] data = {keyword};
		
		BoardMapper mapper = new BoardMapper();	
		JdbcTemplate jdbctemplate = JdbcUtils.getJdbcTemplate();	
		List<BoardDto> list = jdbctemplate.query(sql, mapper, data);
		
		//if(list.size() == 0)
		if(list.isEmpty()) {
			System.out.println("게시글이 존재하지 않습니다");
		}
		else{for(BoardDto dto:list) {
			//System.out.println(dto);
			System.out.println(dto.getBoardTitle());
			System.out.println(dto.getBoardWriter());
			}
		}
	}
}
