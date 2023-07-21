package jdbc;

import java.util.Scanner;

import javax.tools.DiagnosticCollector;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test05 {
	public static void main(String[] args) {
		//계좌 개설 프로그램
		//= 계좌를 개설한다는 것은 Account 테이블에 데이터를 INSERT하는 것이다
		
		Scanner sc = new Scanner(System.in);
		System.out.print("예금주 : ");
		String accountOwner = sc.next();
		System.out.print("예금기간(년) : ");
		int accountPeriod = sc.nextInt();
		//int accountCount = accountPeriod * 12 +1;
		int accountCount = 0;
		System.out.print("1회 예금액 : ");
		int accountPayment = sc.nextInt();
		long accountBalance = 0L;
		
		sc.close();
		
		//DB 처리
		String sql = "insert into account(account_owner, acoount_period, account_count, account_payment, account_balance)"
				+ "values(?,?,?,?,?)";
		Object[] data = new Object[] {accountOwner, accountPeriod, accountCount, accountPayment, accountBalance};
	
		//도구 준비
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, data);
		
		System.out.println("계좌 개설 완료!");
	}
}
