package loop3;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//사용자에게 숫자 입력받고 합계와 평균을 구하여 출력
		//단 사용자가 0을 입력할 경우 프로그램 종료
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int count = 0;
		
		while(true) {
		System.out.print("숫자 입력 : ");
		int number = sc.nextInt();
		
		if(number==0) {
			break;
			}
		
		else{//0빼고 나머지
			sum += number;
			count++;
			}
		}
		
		sc.close(); //while문에서는 멈추는 코드가 있어야 종료도 가능
		double avg = (double)sum / count;
		
		System.out.println("종료!");
		System.out.println("총 합계 : "+sum);
		System.out.println("총 평균 : "+avg);
	}
}
