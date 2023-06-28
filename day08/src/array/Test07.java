package array;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		//사용자에게 나라 이름 5개를 입력 받아서 출력
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[5];
		
		for(int i = 0; i<names.length; i++) {
			System.out.print("나라 이름 입력 : ");
			names[i] = sc.next();
		}
		
		sc.close();
		
		for(int i = 0; i<names.length; i++) {
			System.out.println("나라 이름 = "+names[i]);
		}
	}
}
	