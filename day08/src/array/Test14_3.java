package array;

import java.util.Random;

public class Test14_3 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//데이터 준비
		
		int[] data = new int[] {30,50,20,10,40};
		
		//셔플(뒤섞기)		
		//- 같은 자리 제거
		//- 같은 자리가 나오면 다시 뽑아라
		//- 같은 자리가 나오면 하던 작업을 무효화 시켜라
		
		for(int i = 0; i<data.length; i++) {
		//[i]과 <---> [0~4] 
		int index = r.nextInt(data.length);
		System.out.println("index = "+index);
		
		if(i == index) {
			i--;
			continue;
			}
			
		int backup = data[i]; //0, 1, 2, 3, 4 =for
		data[i] = data[index];
		data[index] = backup;
		}
		
		//출력
		for(int i = 0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
