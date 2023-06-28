package array;

import java.util.Scanner;

public class Tset05 {
	public static void main(String[] args) {
		//배열과 반복문
		// - ex : 3개의 숫자를 입력 받아서 출력, 합계 구하기
		
		int [] data = new int[3];
		
		Scanner sc = new Scanner(System.in); 
		data[0] = sc.nextInt();
		data[1] = sc.nextInt();
		data[2] = sc.nextInt();
		
		sc.close();
		
		System.out.println(data[0]);
		System.out.println(data[1]);
		System.out.println(data[2]);
	}
}
