package api.util.collection;

import java.util.ArrayList;
import java.util.Random;

public class Test04 {
	public static void main(String[] args) {
		//로또 당첨 예상번호 추첨 프로그램
		//for문
		
		Random r = new Random();
		ArrayList<Integer> lotto = new ArrayList<>();		
		
		for(int i=0; i<6; i++) {
			
		int num = r.nextInt(45)+1;
		
		if(lotto.contains(num)) {
			i--;
		}
		else {
			lotto.add(num);			
		}
	}
		System.out.println("로또 예상번호 : "+lotto);			
	}
}
