package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test24 {
	public static void main(String[] args) {
		//도서 정보 상세 조회
		
		int bookId = 2;
		
		BookDao dao = new BookDao();
		BookDto dto = dao.selectOne(bookId);
		
		if(dto == null) {
			System.out.println("찾으시는 도서 번호가 없습니다");
		}
		else {
			System.out.println("<도서 정보>");
			System.out.println("책 제목 : "+dto.getBookTitle());
			System.out.println("저자 : "+dto.getBookPublisher());
			System.out.println("가격 : $"+dto.getBookPrice());
		}
	}
}
