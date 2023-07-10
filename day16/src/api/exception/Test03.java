package api.exception;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일 입력(YYYY-MM-DD) : ");
		String input = sc.next();
		
		sc.close();
		
		String part1 = input.substring(0,4);
		String part2 = input.substring(5,7);
		String part3 = input.substring(8,10);
				
		int year = Integer.parseInt(part1);
		int month = Integer.parseInt(part2);
		int day = Integer.parseInt(part3);
		
		System.out.println("출생년도 : "+year+"년");
		System.out.println("출생월 : "+month+"월");
		System.out.println("출생일 : "+day+"일");
		}
		
		catch(StringIndexOutOfBoundsException e){ 
			//입력 길이가 짧을 때
			System.out.println("입력값이 너무 짧습니다");
		}
		catch(NumberFormatException e) {
			//숫자 변환이 안될 때
			System.out.println("올바른 숫자가 입력되지 않았습니다");
		}
	}
}
