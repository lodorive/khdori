package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03 {
	public static void main(String[] args) {
		//도서 등록 프로그램
		
		//데이터 - DTO
		BookDto dto = new BookDto();
		dto.setBookTitle("룰루랄라 신나는 모험");
		dto.setBookAuthor("해리포터");
		dto.setBookPublication("1960-07-11");
		dto.setBookPrice(14.22f);
		dto.setBookPublisher("하이나라");
		dto.setBookPageCount(550);
		dto.setBookGenre("판타지");
		
		//DB처리
		BookDao dao = new BookDao();
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
