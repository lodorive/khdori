package array;

import java.util.Random;

public class Test14 {
	public static void main(String[] args) {
		//배열의 모든 데이터를 랜덤으로 섞는 코드구현(cf:카드섞기)
		
		//1.모든 자리는 1번씩 다른 위치와 바뀌어야 한다
		//2. 어디랑 섞일지 대상 위치를 모르며 같은 위치일 수 있음
		//3. 랜덤으로 정해진 위치와 현재 위치의 데이터를 바꾸면 됨
		
		Random r = new Random();
		
		int[] card = new int[] {30,50,20,10,40};
		
		
		for(int i = 0; i<card.length; i++) {
			
			int random = r.nextInt(5);
			
			int backup = card[i]; 
			card[i] = card[random];
			card[random] = backup;
			}

		
		for(int i = 0; i<card.length; i++) {
			System.out.println(card[i]);
		}
	}
}
