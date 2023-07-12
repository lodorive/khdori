package api.util.random;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		//Random 클래스
		//= 시드(seed)를 이용하여 복잡한 계산을 거쳐 만들어내는 값
		//= 시드를 제어할 수 있다면 랜덤을 원하는대로 만들 수 있다
		
		Random r1 = new Random();
		Random r2 = new Random(1L);
		
		System.out.println(r1.nextInt());
		System.out.println(r2.nextInt());
	}
}
