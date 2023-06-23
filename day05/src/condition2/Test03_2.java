package condition2;

import java.util.Scanner;

public class Test03_2 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = 25;
		int card = 500;
		
		sc.close();
		
		//계산 - 이용요금을 계산
		int price;
		if(age >=65 || age < 8) {
			price = 0;
		}
		else if(age >=20) {
			price = 1250;
		}
		else if(age >= 14) {
			price = 720;
		}
		else {
			price = 450;
		}
		
		int result = price + card;
		
		//출력
		System.out.println("이용요금은 " +price+ "원 입니다");
		System.out.println("카드보증금은 " +card+ "원 입니다");
		System.out.println("결제요금은 " +result+ "원 입니다");
	}
}
