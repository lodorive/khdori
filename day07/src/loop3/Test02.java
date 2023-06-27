package loop3;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		//while 활용
		//=주사위가 6이 나올 때까지 던지는 코드
		
		Random r = new Random();
		
		//for(;;) { 같은 의미
		while(true) {
			int dice = r.nextInt(6)+1;
			System.out.println("주사위 : "+dice);
			
			if(dice==6) {
				break;
			}
		}
	}
}
