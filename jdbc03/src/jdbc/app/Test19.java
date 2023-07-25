package jdbc.app;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test19 {
	public static void main(String[] args) {
		//데이터 없음
		
		//DB처리
		BookDao dao = new BookDao();
		List<BookDto> list = dao.selectList();
				
		if(list.isEmpty()) {
			System.out.println("등록된 도서가 없습니다");
		}
		else {
			System.out.println("총 "+list.size()+"개의 도서가 존재합니다");
			for(BookDto dto : list) {
				System.out.println(dto.getBookTitle()+"($"+dto.getBookPrice()+")");
			}
		}
	}
}
