package random;

import java.util.Random;
import java.util.Scanner;

public class Test05_2 {
	public static void main(String[] args) {
		
		//랜덤 구구단 문제 풀이
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int correct = 0;
		int incorrect = 0;
		
		for(int i = 0; i<10; i++) {
		int a = r.nextInt(8)+2;
		int b = r.nextInt(9)+1;
		System.out.print(a + " X " +b+ " = ");

		int user = sc.nextInt();
		
		if(a*b == user) {
			System.out.println("정답");
			correct++;
		}
		else {
			System.out.println("오답");
			incorrect++;
			}
		}
		sc.close();
		
		System.out.println("게임 끝!");
		System.out.println("총 " +correct+" 문제 맞추셨습니다");
		System.out.println("틀린 개수는 " +incorrect+" 개 입니다");
	}
}
