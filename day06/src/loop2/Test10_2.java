package loop2;

import java.util.Scanner;

public class Test10_2 {
	public static void main(String[] args) {
		//문제 풀이
		Scanner sc = new Scanner(System.in);
		
		int total = 0;
		
		System.out.print("일 수 입력 : ");
		int day = sc.nextInt();
		
		for(int i = 0; day < 5; i++) {			
			System.out.print("공부한 시간 : ");
			int hour = sc.nextInt();
			
			System.out.print("공부한 분 : ");
			int minute = sc.nextInt();			
			
			int time = hour * 60 + minute;
			total += time;
		}		
		
		sc.close();
		
		int hour = total / 60;
		int minute = total % 60;
		
		System.out.println("총 공부한 시간은 "+hour+"시간 "+minute+"분 입니다");

		int average = total / day;
		int averageHour = average / 60;
		int averageMin = average % 60;
		
		System.out.println("일 평균 약 "+averageHour+" 시간"+averageMin+"분 입니다");
}
	}