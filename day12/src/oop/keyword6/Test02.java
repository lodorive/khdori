package oop.keyword6;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		System.out.print("닉네임 : ");
		String name = sc.next();
		
		Member a = new Member(id, pw, name);
		a.show();
	}
}
