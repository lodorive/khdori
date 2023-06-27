package random;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		//모두의 마블 게임
		//한 턴에 주사위 두 개를 던진다
		//주사위 두 개가 같은 값이 나오면 '더블'이라고 부르며 한 번 더 던질 수 있다
		
		//100턴 동안 주사위를 던졌을 때 더블이 몇 번 나오는지 카운트해서 출력
		//더블이 나올 확률을 구하여 출력
		
		Random r = new Random();
		
		int count = 0;
		
		for(int i = 0; i<100; i++) { //100턴 동안 주사위를 던진다

			int a = r.nextInt(6) +1; //1부터 6까지
			int b = r.nextInt(6) +1; //1부터 6까지
			System.out.println("주사위 a의 숫자 : "+a+"주사위 b의 숫자 : "+b);
			
		if(a==b) {
			System.out.println("더블!");
			count++;
			}
		else {
			}
		}
				
		System.out.println("100턴 동안 더블이 나오는 횟수 : "+count+"개");
	}
}
