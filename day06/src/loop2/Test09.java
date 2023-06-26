package loop2;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		//사용자에게 숫자를 10개 입력 받아서 다음을 계산
		//홀수의 개수, 짝수의 개수, 전체 합계, 전체 평균

		Scanner sc = new Scanner(System.in);
		
		int odd = 0;
		int even = 0;
		int total = 0;
		
		for(int i = 0; i<10; i++) {//10개 반복
			System.out.print("숫자를 10개 입력하세요 : "); //10개 입력			
			int num = sc.nextInt();
			total += num;
			if(num % 2 != 0) {//홀수의 개수
				odd++;
			}
			else {//짝수의 개수
				even++;
			}
		}
		
		sc.close();
		
		System.out.println("홀수의 개수는 "+odd+"개 입니다");
		System.out.println("짝수의 개수는 "+even+"개 입니다");
		System.out.println("전체 합계는 "+total+"개 입니다");
		System.out.println("전체 평균은 "+total/10+"개 입니다");
	}
}
