package api.lang.string;

import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) {
		//닉네임 설정 문제 풀이 
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임을 입력하세요 : ");
		String name = sc.next();
		sc.close();
		
		//출력
		if(name.length() < 2 || name.length() >10) {
			System.out.println("닉네임을 2글자 이상 10글자 이하로 입력하세요");
		}
		else if(name.contains("운영자")) {
			System.out.println("'운영자' 라는 닉네임은 사용할 수 없습니다");
		}
		else {
			System.out.println("닉네임 설정이 완료되었습니다");
		}
	}
}
