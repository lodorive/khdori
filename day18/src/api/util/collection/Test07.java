package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test07 {
	public static void main(String[] args) {
		//도우미 클래스(Collections)
		//= s가 붙은 클래스는 대부분 도우미 클래스
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		
		//리스트 뒤집기(reverse)
		Collections.reverse(list);
		System.out.println(list);
		
		//리스트 섞기(shuffle)
		Collections.shuffle(list);
		System.out.println(list);
		
		//리스트 정렬(sort)
		Collections.sort(list);
		System.out.println(list);
		
		//ex : 로또번호 6개 추첨
		//= 리스트에 1부터 45까지를 담아두고 섞어서 6개만 추첨
		ArrayList<Integer> lotto = new ArrayList<Integer>();
		for(int i=1; i<=45; i++) {
			lotto.add(i);
		}
		Collections.shuffle(lotto);
		System.out.println(lotto);
		
		List<Integer> result = lotto.subList(0, 6);
		Collections.sort(result);
		System.out.println(result);
	}
}
