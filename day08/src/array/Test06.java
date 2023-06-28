package array;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		//사용자에게 실수 5개를 입력 받아서 출력하도록 프로그램 구현
		Scanner sc = new Scanner(System.in);
		
		double[] data = new double[5];
		
		for(int i = 0; i < data.length; i++) { //배열의 전체 범위를 반복하는 공식
			System.out.print("실수 5개 입력 : ");
			data[i] = sc.nextDouble();
			}

		sc.close();
		
		for(int i = 0; i < data.length; i++) {
		System.out.println("데이터 = " +data[i]);
		}
	}
}
