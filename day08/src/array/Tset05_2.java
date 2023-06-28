package array;

import java.util.Scanner;

public class Tset05_2 {
	public static void main(String[] args) {
		//배열과 반복문
		// - ex : 3개의 숫자를 입력 받아서 출력, 합계 구하기
		
		int [] data = new int[3];
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("숫자 3개 입력");
		for(int i = 0; i <= 2; i++) {
			data[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = 0; i <=2; i++) {
			System.out.println(data[i]);
		}
		
	}
}
