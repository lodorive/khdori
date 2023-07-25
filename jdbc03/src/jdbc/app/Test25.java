package jdbc.app;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test25 {
	public static void main(String[] args) {
		
		int boardNo = 41;
		
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.selectOne(boardNo);
		
		if(dto == null) {
			System.out.println("찾으시는 게시글이 없습니다");
		}
		else {
			System.out.println("게시글 제목 : "+dto.getBoardTitle());
			System.out.println("게시글 내용 : "+dto.getBoardContent());
		}
	}
}
