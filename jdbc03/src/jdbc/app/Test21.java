package jdbc.app;

import java.util.List;

import jdbc.dao.BoardDao;
import jdbc.dto.BoardDto;

public class Test21 {
	public static void main(String[] args) {
		//데이터
		int page = 2;
		
		//DB처리
		BoardDao dao = new BoardDao();
		List<BoardDto> list = dao.selectListByPage(page);
		
		//System.out.println("총 "+list.size()+"개의 글이 있습니다"); 의미없음
		for(BoardDto dto : list) {
			System.out.print("["+dto.getBoardNo()+"] ");
			System.out.println(dto.getBoardTitle());
		}
	}
}
