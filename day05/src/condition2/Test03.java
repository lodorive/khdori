package condition2;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//지하철 이용요금
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("정류장 수를 입력하세요 : ");
		int station = sc.nextInt();
		
		sc.close();
		
		int adult = 1250;
		int teen = 720;
		int child = 450;

		//추가
		int deposit = 500;
		int stationPay = station / 5 * 100;
		
		//계산
		
		int pay;
		if(age >= 20 && 65 > age){
			pay = adult + deposit + stationPay;	
		}
		else if(age >= 14 && 20 > age){
			pay = teen + deposit + stationPay;	
		}
		else if(age >= 8 && 14 > age){
			pay = child + deposit + stationPay;	
		}
		else {
			pay = deposit + stationPay;
		}
		
		//출력;
		System.out.println("카드보증금은 " +deposit+ "원 입니다");
		System.out.println("추가요금은 " +stationPay+ "원 입니다");
		System.out.println("결제요금은 " +pay+ "원 입니다");
	}
}
