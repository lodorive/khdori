package array2;

import java.util.Arrays;

public class Test01_2 {
	public static void main(String[] args) {
		//정렬(sort)
		//데이터 준비
		int[] data = new int[] {10,20,50,30,40};
		
		//선택 정렬 - 3회차(+2부터 +4지점에서 최소값을 찾아 +1지점과 교체)
		int minIndex = 2; // 2번 위치의 값이 제일 작다고 생각(0~3)
		
		for(int i = 3; i<=4; i++) {//뒤에 있는 데이터와 비교하여
			if(data[minIndex] > data[i]) {//더 작은 값이 있다면
				minIndex = i; //교체!
		}
			}
		System.out.println(minIndex);
			
		int backup = data[minIndex];
			data[minIndex] = data[2];
			data[2] = backup;		
		
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
