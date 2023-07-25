package jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BoardDto;
import jdbc.mapper.BoardMapper;
import jdbc.util.JdbcUtils;

//게시글을 CRUD 처리하는 도구
public class BoardDao {
	
		//C(등록) 메소드
		public void insert(String boardTitle, String boardContent, String boardWriter) {
		
		}
		
		//바람직한 형태의 등록 메소드
		public void insert(BoardDto dto){
			
			String sql = "insert into board(board_no, board_title, board_content, "
					+ "board_writer, board_readcount)"
					+ "values(board_seq.nextval,?,?,?,0)";
			
			Object[] data = {dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardWriter()};
			
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			jdbcTemplate.update(sql, data);			
		}
		
		//수정 기능
		public boolean update(BoardDto dto) {
			
			String sql = "update board set board_title=?, board_content=? where board_no=?";
			Object[] data = {   
					dto.getBoardTitle(), dto.getBoardContent(), dto.getBoardNo()
			};
			
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			//int result = jdbcTemplate.update(sql, data);
			//return result > 0;
			return jdbcTemplate.update(sql, data) >0;
			}
		
		//삭제 기능
		public boolean delete(int boardNo) {
			String sql = "delete board where board_no=?";
			Object[] data = {boardNo};
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			return jdbcTemplate.update(sql, data) >0;
		}
		
		//Mapper 생성
		private BoardMapper mapper = new BoardMapper();
		
		//게시글 목록
		public List<BoardDto> selectList(){
			String sql = "select * from board order by board_no desc";
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			return jdbcTemplate.query(sql, mapper);
		}
		
		//(심화) 페이징 목록 조회
		public List<BoardDto> selectListByPage(int page){
			int end = page * 10;
			int begin = end - 9;
			
			String sql = "select * from ("
								+ "	select rownum rn, TMP.* from ("
								+ "		select * from board order by board_no desc"
								+ "	)TMP"
								+ ") where rn between ? and ?";
			Object[] data = {end, begin};			
			JdbcTemplate jdbcTemplate = JdbcUtils.getJdbcTemplate();
			return jdbcTemplate.query(sql, mapper, data);			
		}
	}

