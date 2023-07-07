package api.lang.string;

import java.util.Scanner;

public class Test06_2 {
	public static void main(String[] args) {
		//쿵쿵따 게임 1턴 구현
		Scanner sc = new Scanner(System.in);
		
		String given = "바나나";
		System.out.println("제시어 : "+given);
		
		System.out.print("입력 : ");
		String input = sc.next();	
		sc.close();
		
		//판정
		//[1] 3글자인지 판정
		//[2] 이어지는지 판정
		
		if(input.length() == 3 && given.charAt(2) == input.charAt(0)){
			System.out.println("합격!");
		}
		else {
			System.out.println("게임오버");
		}
	}
}

