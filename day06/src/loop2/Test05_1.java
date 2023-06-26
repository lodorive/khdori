package loop2;

import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		//구구단 게임 문제풀이
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단 : ");
		int dan = sc.nextInt();
		
		int ok = 0;
		int nok = 0;
		int combo = 0;
		
		//for(1부터 9까지)
		for(int i=1; i<=9; i++) {
		System.out.print(dan + " x " + i +" = ");
		int user = sc.nextInt();
		
		if(dan * i == user){
			System.out.println("정답");
			ok++;
			combo++;
			System.out.println(combo+"콤보!");
		}
		else {
			System.out.println("오답");
			nok++;
			combo = 0;
		}
		}
		sc.close();
		System.out.println("맞은 개수 : " +ok);
		System.out.println("틀린 개수 : " +nok);
	}
}
