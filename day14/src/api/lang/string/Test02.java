package api.lang.string;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디 : ");
		String id = sc.next();
		System.out.println("비밀번호 : ");
		String pw = sc.next();
		
		//계산
		if(id.equals("khacademy")) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
		if(pw.equals(pw.toUpperCase())) { 
			System.out.println("로그인 실패");
		}
		else {
			System.out.println("로그인 성공");
		}
	}
	}