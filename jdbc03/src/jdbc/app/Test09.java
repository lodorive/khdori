package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test09 {
	public static void main(String[] args) {
		//도서명, 저자, 출판사 수정 프로그램(도서 기본정보)
		
		//데이터
		BookDto dto = new BookDto();
		dto.setBookId(60);
		dto.setBookTitle("제목 변경");
		dto.setBookAuthor("저자 변경");
		dto.setBookPublisher("출판사 변경");
		
		//DB처리
		BookDao dao = new BookDao();
		boolean result = dao.updateBookInfo(dto);
		
		if(result) {
			System.out.println("도서 정보가 변경되었습니다");
		}
		else {
			 System.out.println("도서 번호가 존재하지 않습니다");
		}
	}
}
