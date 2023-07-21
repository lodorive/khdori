package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test08 {
	public static void main(String[] args) {
		//회원 가입 프로그램
				
		//데이터 - 6개
		//(TIP) 오라클에 추가하는 문자열은 null이든 ""이든 모두 null로 추가됨
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 입력 : ");
		String memberId = sc.nextLine();
		System.out.println("비밀번호 입력 : ");
		String memberPw = sc.nextLine();
		System.out.println("닉네임 입력 : ");
		String memberNickname = sc.nextLine();
		System.out.println("생년월일 입력(2000-01-01) : ");
		String memberBirth = sc.nextLine();
		System.out.println("이메일 입력 : ");
		String memberEmail = sc.nextLine();
		System.out.println("휴대폰번호 입력(-제외) : ");
		String memberContact = sc.nextLine();
		//String memberLevel = "일반";
		//int memberPoint = 0;
		//String memberJoin = "2023-07-21";
		
		//DB 처리
		//String sql = "insert into member(MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME, MEMBER_BIRTH,"
		//		+ "MEMBER_EMAIL, MEMBER_CONTACT, MEMBER_LEVEL, MEMBER_POINT, MEMBER_JOIN)"
		//		+ "values(?,?,?,?,?,?,default,default,default)";
		
		String sql = "insert into member(MEMBER_ID, MEMBER_PW, MEMBER_NICKNAME, MEMBER_BIRTH,"
				+ "MEMBER_EMAIL, MEMBER_CONTACT, MEMBER_LEVEL, MEMBER_POINT, MEMBER_JOIN)"
				+ "values(?,?,?,?,?,?)";
		
		Object[] data = {
				memberId, memberPw, memberNickname, memberBirth, memberEmail, memberContact
		};
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername("C##KH");
		dataSource.setPassword("KH");
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, data);
		
		System.out.println("회원 가입 완료!");
	
	}
}
