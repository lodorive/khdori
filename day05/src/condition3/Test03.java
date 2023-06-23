package condition3;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		//1월부터 12월은 각각 정해진 날짜 수가 존재한다
		//31일까지 존재하는 달(1, 3, 5, 7, 8, 10, 12)
		//30일까지 존재하는 달(4, 6, 9, 11)
		//28일까지 존재하는 달(2)
	
		//입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("해당 월을 입력하세요 : ");
		int month = sc.nextInt(); 
		
		sc.close();
		
		//계산
		int days;
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			days = 31;
		break;
		case 4, 6, 9, 11:
			days = 30;
		break;
		default:
			days = 28;
			break;
		}	
		
		//출력
		System.out.println("해당하는 달의 날짜 수는 " +days+ "일 입니다");
	}
	
}
