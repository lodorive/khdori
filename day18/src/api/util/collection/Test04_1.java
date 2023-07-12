package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test04_1 {
	public static void main(String[] args) {
		//로또 당첨 예상번호 추첨 프로그램
		//while문
		
		Random r = new Random();
		ArrayList<Integer> lotto = new ArrayList<>();		
		
		while(lotto.size()<6) {			
		int num = r.nextInt(45)+1;	 //auto-boxing(int임에도 Integer에 들어감) 
		if(!lotto.contains(num)) {
			lotto.add(num);			
		}
	}
		System.out.println("로또 예상번호 : "+lotto);			
	}
}
