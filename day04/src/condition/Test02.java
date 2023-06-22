package condition;

import java.util.Scanner;
public class Test02 {
	public static void main(String[] args) {
		//고3 수험생을 대상 이벤트 진행 프로그램
		//출생년도를 입력 받아 19살인 경우 이벤트 대상입니다
		//아니라면 대상이 아닙니다 출력
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출생년도를 입력하세요 : ");
		int birth = sc.nextInt();
		
		sc.close();
		
		//계산
		int year = 2023;
		int age = year - birth + 1;
		//System.out.println(age);
		
		//출력
		if(age == 19){
			System.out.println("이벤트 대상입니다");
		}
		else {
			System.out.println("이벤트 대상이 아닙니다");
		}				
	}
}
