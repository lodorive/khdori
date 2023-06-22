package input;

import java.util.Scanner;
public class Test04 {
	public static void main(String[] args){
		
		//강의장 입실시각과 퇴실시각을 입력 빋아
		//실제 수업에 참여한 시간을 계산하여 출력
		
		//입력
		Scanner sc = new Scanner(System.in);		
		
		System.out.print("입실시각을 입력하세요 : ");
		int enter = sc.nextInt();
		System.out.print("퇴실시각을 입력하세요 : ");
		int leave = sc.nextInt();
		
		sc.close();
		
		//계산
		//int enterTime = (leave - enter) / 100;
		//int leaveTime = (leave - enter) % 100;
		
		int enterHour = enter / 100;
		int enterMin = enter % 100;
		
		int leaveHour = leave / 100;
		int leaveMin = leave % 100;
		
		int enterTime = enterHour * 60 + enterMin;
		int leaveTime = leaveHour * 60 + leaveMin;
		
		int time = leaveTime - enterTime;
		int hour = time / 60;
		int minute = time % 60;
		
		//출력
		System.out.print("수업에 참여한 시간은 ");
		System.out.print(hour + "시간 " + minute + "분 입니다");	
	}
}
