package jdbc.app;

import jdbc.dao.BoardDao;

public class Test13 {
	public static void main(String[] args) {
		
		int boardNo = 1;
		
		BoardDao dao = new BoardDao();
		boolean result = dao.delete(boardNo);
		
		if(result) {
			System.out.println("게시글 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 게시글 번호");
		}
	}
}
