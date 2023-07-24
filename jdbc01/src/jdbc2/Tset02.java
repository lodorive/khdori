package jdbc2;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Tset02 {
	public static void main(String[] args) {
		//도서 정보 수정 프로그램
		
		Scanner sc = new Scanner(System.in);
		//데이터 준비
		
		System.out.println("북 넘버 : ");
		int bookId = sc.nextInt();
		System.out.println("변경 제목 : ");
		sc.nextLine();
		String bookTitle = sc.nextLine();
		System.out.println("변경 가격 : ");
		float bookPrice = sc.nextFloat();
		
		//DB처리 - 자바는 자동 commit 모드를 사용한다
		String sql = "update book set book_title=?, book_price=? where book_id = ?";
		Object[] data = {bookTitle, bookPrice, bookId};
		
		//실행 명령
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, data);
		
		int result = jdbcTemplate.update(sql, data);
		System.out.println("result = "+result);
		
		if(result > 0) {
		System.out.println("변경이 완료되었습니다");
		}
		else {
			System.out.println("올바르지 않은 도서 번호");
		}
	}
}