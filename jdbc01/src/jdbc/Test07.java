package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test07 {
	public static void main(String[] args) {
		//게시글 등록 프로그램
		
		//데이터
		Scanner sc = new Scanner(System.in);
		System.out.println("제목 입력 : ");
		String boardTitle = sc.nextLine();
		System.out.println("내용 입력 : ");
		String boardContent = sc.nextLine();
		System.out.println("작성자 입력 : ");
		String boardWriter = sc.nextLine();
		//int boardReadCount = 0;
		
		
		//DB 처리
		String sql = "insert into board(BOARD_NO, BOARD_TITLE, BOARD_CONTENT, BOARD_WRITER, BOARD_READCOUNT)"
				+ "values(board_seq.nextval,?,?,?,0)";
		Object[] data = {
				boardTitle, boardContent, boardWriter
		};
		
		//도구 준비
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, data);
		
		System.out.println("데이터 등록 완료!");
	}
}
