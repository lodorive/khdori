package jdbc.app;

import jdbc.dao.PocketmonDao;

public class Test12 {
	public static void main(String[] args) {
		//포켓몬스터 삭제 프로그램
		
		//데이터
		int no = 50;
		
		//DB처리
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.delete(no);
		
		if(result) {
			System.out.println("포켓몬스터 정보 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 포켓몬스터 번호");
		}
	}
}
