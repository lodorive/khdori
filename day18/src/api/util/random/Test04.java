package api.util.random;

import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		//여러가지 Random의 명령들
		Random r = new Random();
		
		System.out.println(r.nextBoolean());
		System.out.println(r.nextInt());
		System.out.println(r.nextLong());
		System.out.println(r.nextFloat()); //0이상 1미만
		System.out.println(r.nextDouble()); //0이상 1미만
		System.out.println(r.nextGaussian()); //정규분포
	}
}
