package loop;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		//사용자에게 숫자를 5번 입력받는 프로그램을 구현
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int number = sc.nextInt();
		
		sc.close();
		
		for(number = 0; number < 5; number ++){
			System.out.println("숫자를 입력하세요 : ");
		}
		
	}
}
