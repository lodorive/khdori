package loop3;

import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		//숫자 모래성 땅따먹기 게임
		
		//최초 100이라는 값을 정해두고 
		//사용자에서 한 자리 숫자(1~9)를 입력 받아 차감을 한다
		//차감을 하다가 0이하가 되면 반복을 종료하고 게임 오버 메시지 출력
		//몇 번 만에 게임 오버가 되었는지 측정하여 출력
		
		Scanner sc = new Scanner(System.in);

		
		int num = 100;
		int count = 0;
		
		while(true) {
		System.out.print("한 자리 숫자 입력 : ");
		int input = sc.nextInt();
		
		//원치 않는 상황이면 SKIP 하도록 처리
		//if(input <1 || input >9) {
		if(!(input >=1 && input <=9)) {
			System.out.println("1~9만 입력 가능");
			continue; //처음으로 이동
		}
		count++;
		
		num -= input; // 차감처리(누적)
		System.out.println("남은 숫자 : "+num);
		
			if(num <= 0) {
				break;
			}
				else {
					System.out.println("0~9만 입력하세요");
			}	
	}
		sc.close();
		System.out.println("게임 오버");
		System.out.println("총 입력한 횟수는 "+count+ "번 입니다");
	}
}
