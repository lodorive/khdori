package jdbc.app;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test08 {
	public static void main(String[] args) {
		//도서 가격 수정 프로그램
		
		//데이터
		BookDto dto = new BookDto();
		dto.setBookId(60);
		dto.setBookPrice(19.22f);
		
		//DB 처리
		BookDao dao = new BookDao();
		boolean result = dao.updateBookPrice(dto);
		
		if(result) {
			System.out.println("가격 변경이 완료되었습니다");
		}	
		else {
				System.out.println("도서 번호가 존재하지 않습니다");
			}
		}
	}
