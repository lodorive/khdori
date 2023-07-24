package jdbc2;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03 {
	public static void main(String[] args) {
		//게시글 정보 수정 프로그램
		
		Scanner sc = new Scanner(System.in);
		//데이터 준비
		System.out.println("넘버 입력 : ");
		int boardNo = sc.nextInt();
		System.out.println("변경 제목 : ");
		sc.nextLine();
		String boardTitle = sc.nextLine();
		System.out.println("변경 내용 : ");
		String boardContent =  sc.nextLine();
	
		//DB처리
		String sql = "update board set BOARD_TITLE=?, BOARD_CONTENT=? "
				+ "where BOARD_NO = ?";
		Object[] data = {boardTitle, boardContent, boardNo};
		
		//실행 명령
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		//처리도구
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, data);
		
		int result = jdbcTemplate.update(sql, data);
		System.out.println("result = "+result);
		
		if(result > 0) {
		System.out.println("게시글 수정 완료");
		}
		else {
			System.out.println("존재하지 않는 게시글 번호");
		}
	}
}
