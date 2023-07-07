package api.lang.string;

import java.util.Scanner;

public class Test06_3 {
	public static void main(String[] args) {
		//쿵쿵따 게임 반복문 구현
		Scanner sc = new Scanner(System.in);
		
		String given = "바나나";
		
		while(true) {
		System.out.println("제시어 : "+given);
		
		System.out.print("입력 : ");
		String input = sc.next();	
		
		//판정
		//[1] 3글자인지 판정
		//[2] 이어지는지 판정
		
		if(input.length() == 3 && given.charAt(2) == input.charAt(0)){
			given = input; //제시어 교체
		}
		else {
			System.out.println("게임오버");
			break;
		}
	}
		sc.close();
	}
}

