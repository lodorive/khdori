package loop;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) throws InterruptedException {
		//타이머 구현
		//사용자에게 '분'과 '초'를 입력받아 해당 시간만큼 메시지를 출력하는 타이머 구현
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("분을 입력하세요 : ");
		int minute = sc.nextInt();
		System.out.print("초를 입력하세요 : ");
		int second = sc.nextInt();
		
		sc.close();
		
		//계산
		int time = minute * 60 + second;
		
		//출력
		for(int i = time; i>= 0; i--) {
			int min = i / 60;
			int sec = i % 60;
			System.out.println(min+"분 "+sec+"초 후 알람이 울립니다!");
			
			//1초 대기
			if(i > 0) {
			Thread.sleep(1000);
			}
		}
		System.out.println("알람 시작!");
	}
}
