package array;

import java.util.Scanner;

public class Test01 {
	public static void mainr(String[] args) {
		//배열(array)
		
		//ex : 숫자 3개를 입력받아서 출력하는 프로그램
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 3개를 입력하세요");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
