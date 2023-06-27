package random;

import java.util.Random;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//랜덤으로 2단부터 9단 사이의 문제를 10개 출제
		//사용자 입력
		//정답/오답 판정
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int ok = 0;
		int nok = 0;
		
		for(int i = 1; i<=10; i++) {
			int dan = r.nextInt(8) +2; //2부터 8까지
			int dan2 = r.nextInt(9) +1; // 1부터 9까지
			System.out.print(dan+" x "+dan2+" = ");
			int user = sc.nextInt();
			
		if(dan * dan2 == user) {
			System.out.println("정답");
			ok++;
		}
		else {
			System.out.println("오답");
			nok++;
		}
		}
		sc.close();
		System.out.println("정답 개수 : "+ok);
		System.out.println("정답 개수 : "+nok);
	}
}
