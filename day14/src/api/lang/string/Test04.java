package api.lang.string;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//사용자에게 프로그램 내에서 사용할 닉네임을 입력 받도록 구현
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("닉네임을 입력하세요 : ");
		String name = sc.next();
		
		//계산
		boolean a = name.length()<=2 || name.length()>=10;
		boolean b = name.equals("운영자");

		//출력
		if(a) {
			System.out.println("닉네임을 2글자 이상 10글자 이하로 입력하세요");
		}
		else if(b) {
			System.out.println("'운영자' 라는 닉네임은 사용할 수 없습니다");
		}
		else {
			System.out.println("닉네임 설정이 완료되었습니다");
		}
	}
}
