package jdbc.app;

import java.awt.BorderLayout;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test02 {
	public static void main(String[] args) {
		
		//데이터
		BoardDto dto = new BoardDto();
		dto.setBoardTitle("제목");
		dto.setBoardContent("내용");
		dto.setBoardWriter("testuser5655");
		
		//처리
		BoardDao dao = new BoardDao();
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
