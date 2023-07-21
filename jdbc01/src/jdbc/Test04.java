package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test04 {
	public static void main(String[] args) {
		//변수로 가지고 있는 데이터를 기반으로 명령을 생성하여 전송하는 방법
		
		int no = 50;
		String name = "테스트";
		//String name = "테'스'트";
		String type = "무속성";
		
		//동적 SQL 생성 방식
		//- 구문과 값을 준비해서 처리한 뒤 합성하는 방식
		//- 데이터 자리를 홀더(?)로 표기
		//- 구문과 합쳐져야 하는 데이터를 따로 준비
		//- 자료형에 맞게 알아서 변환되어 처리(ex : 따옴표 등)
		String sql = "insert into pocketmon(no, name, type) values(?,?,?)";
		Object[] data = new Object[] {no, name, type}; //배열의 약식 표현(From C언어)
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); //DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, data);
		
		System.out.println("임무완료!");
	}
}
