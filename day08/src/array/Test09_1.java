package array;

import java.util.Random;

public class Test09_1 {
	public static void main(String[] args) {
		//주사위를 1000번 던졌을 때 모든 숫자가 나온 횟수 측정하기(배열)
		
		Random r = new Random();
		
		int[] countList = new int[6];
		
		for(int i = 0; i<1000; i++) {
			int dice = r.nextInt(6)+1;
			countList[dice-1]++;
		}
		
		for(int i = 0; i<countList.length; i++) {
		System.out.println((i+1)+" 나온 횟수 : "+countList[i]);
		}
	}
}
