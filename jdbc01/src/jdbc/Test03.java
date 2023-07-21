package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test03 {
	public static void main(String[] args) {
		//변수로 가지고 있는 데이터를 기반으로 명령을 생성하여 전송하는 방법
		
		int no = 50;
		String name = "테스트";
		String type = "무속성";
		
		//정적 SQL 구문 방식
		//- 구문을 개발자가 직접 완성하는 방식(사전에 완성해서 전송하는 방식)
		//- 구문을 만들기가 매우 까다로움
		//- 등록이 불가능한 글자가 있음
		//- SQL Injection 공격의 대상이 됨
		String sql = "insert into pocketmon(no, name, type) "
				      + "values("+no+",'"+name+"','"+type+"')";
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); //DB종류
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); //DB위치+연결방식
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
		
		System.out.println("임무완료!");
	}
}
