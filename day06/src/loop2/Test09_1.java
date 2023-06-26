package loop2;

import java.util.Scanner;

public class Test09_1 {
	public static void main(String[] args) {
		//사용자에게 숫자를 10개 입력 받아서 다음을 계산
		//홀수의 개수, 짝수의 개수, 전체 합계, 전체 평균
		//문제 풀이
		
		Scanner sc = new Scanner(System.in);
		
		int odd = 0;
		int even = 0;
		int total = 0;
		
		for(int i = 0; i<10; i++) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			
			total += num;
			
			if(num % 2 != 0) {
				odd++;
			}
			else {
				even++;
			}
		}
		sc.close();
		
		double avg = (double)total / 10;
		System.out.println("홀수의 개수 = "+odd);
		System.out.println("짝수의 개수 = "+even);
		System.out.println("전체 합계 = "+total);
		System.out.println("전체 평균 = "+avg);
	}
}
