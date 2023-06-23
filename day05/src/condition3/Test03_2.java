package condition3;

import java.util.Scanner;

public class Test03_2 {
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
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31일");
		break;
		case 4: case 6: case 9: case 11:
			System.out.println("30일");
		break;
		default:
			System.out.println("28일");
		}	
	}
	
}
