package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;

public class Test06 {
	public static void main(String[] args) {
		//도서 등록 프로그램(ex : 도서관, 책방, ...)
		Scanner sc = new Scanner(System.in);
		
		//데이터 - book_id는 준비하지 않는다(시퀀스 활용)
		System.out.print("책 제목 : ");
		String bookTitle = sc.nextLine();
		System.out.print("작가 : ");
		String bookAuthor = sc.nextLine();
		System.out.print("출시일 : ");
		String bookPublcationDate = sc.nextLine();
		System.out.print("가격 : ");
		double bookPrice = sc.nextDouble();
		System.out.print("출판사 : ");
		String bookPublisher = sc.nextLine();	
		sc.nextLine();
		System.out.print("페이지 수 : ");
		int bookPageCount = sc.nextInt();
		System.out.print("장르 : ");
		sc.nextLine();
		String bookGenre = sc.nextLine();
		
		sc.close();
		
		//DB 처리
		String sql = "insert into book(book_id, book_title, book_author, book_publication_date, book_price, book_publisher, book_page_count, book_genre)"
				+ "values(book_seq.nextval,?,?,?,?,?,?,?)";
		Object[] data = new Object[] {
				bookTitle, bookAuthor, bookPublcationDate, bookPrice, bookPublisher, bookPageCount, bookGenre};
		
		//도구 준비
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, data);
		
		System.out.println("도서 등록 완료!");
	}
}
