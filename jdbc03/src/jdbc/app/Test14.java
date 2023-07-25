package jdbc.app;

import jdbc.dao.BookDao;

public class Test14 {
	 public static void main(String[] args) {
		
		 int bookId = 23;
		 
		 BookDao dao = new BookDao();
			boolean result = dao.delete(bookId);
			
			if(result) {
				System.out.println("도서 삭제 완료");
			}
			else {
				System.out.println("존재하지 않는 도서 번호");
			}
		}
	}
