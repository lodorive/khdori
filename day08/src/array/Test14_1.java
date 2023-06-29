package array;

import java.util.Random;

public class Test14_1 {
	public static void main(String[] args) {
		
		Random r = new Random();
		
		//데이터 준비
		
		int[] data = new int[] {30,50,20,10,40};
		
		//셔플(뒤섞기)
		//[0]과 <---> [0~4] 
		
		int index = r.nextInt(data.length);
		System.out.println("index = "+index);
		
		int backup = data[0];
		data[0] = data[index];
		data[index] = backup;
				
		
		
		//출력
		for(int i = 0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
