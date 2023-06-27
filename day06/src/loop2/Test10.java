package loop2;

import java.util.Scanner;

public class Test10 {
public static void main(String[] args) {
		//사용자에게 월요일부터 금요일까지(5번) 공부한 시간 입력받기
		//총 공부한 시간
		//일 평균 공부한 시간
		//입력은 '시간'과 '분'을 따로 받으며 출력도 '시간'과 '분'을 따로 받기
		
		Scanner sc = new Scanner(System.in);
		
		int totalHour = 0;
		int totalMin = 0;
		
		for(int i = 0; i<5; i++) {
		System.out.print("시간 입력(시) : ");
		int hour = sc.nextInt();
		System.out.print("시간 입력(분) : ");
		int min = sc.nextInt();

		totalHour += hour; //시간 누적
		totalMin += min; //분 누적
		
		}
		sc.close();
		
		int total = totalHour * 60 + totalMin;
		int hour2 = total / 60;
		int min2 = total % 60;
		
		int avg = total / 5;
		int avgHour = avg / 60;
		int avgMin = avg % 60;
		
		//총 공부한 시간은 ?시간 ?분
		//일 평균 약 ?시간 ?분
		
		System.out.println("총 공부한 시간은 "+hour2+"시간 "+min2+"분 입니다");
		System.out.println("일 평균 약 "+avgHour+" 시간"+avgMin+"분 입니다");
		}
				
	}