package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02 {
	public static void main(String[] args) {
		//JDBC(Java DataBase Connectivity)
		//= 자바를 이용해서 데이터베이스 작업을 하는 것
		//= 데이터베이스 구문을 프로그램에 작성하여 처리하도록 중계
		
		//(ex) 포켓몬스터 테이블에 데이터를 등록하는 작업
		
		//[1] 구문을 세미콜론 제외하고 준비
		String sql = "insert into pocketmon(no, name, type) values(43,'뚜벅초','풀')";
		
		//[2] 연결 도구 생성 및 연결에 필요한 정보를 설정
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		//[3] 구문 전송 도구 생성 및 전송
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);		
		jdbcTemplate.update(sql);
		
		System.out.println("임무완료");
	}
}
