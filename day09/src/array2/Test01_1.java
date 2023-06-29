package array2;

import java.util.Arrays;

public class Test01_1 {
	public static void main(String[] args) {
		//정렬(sort)
		//데이터 준비
		int[] data = new int[] {10,50,20,30,40};
		
		//선택 정렬 - 2회차(+1부터 +4지점에서 최소값을 찾아 +1지점과 교체)
		int minIndex = 1; // 1번 위치의 값이 제일 작다고 생각
		
		for(int i = 2; i<=4; i++) {//뒤에 있는 데이터와 비교하여
			if(data[minIndex] > data[i]) {//더 작은 값이 있다면
				minIndex = i; //교체!
		}
			}
		System.out.println(minIndex);
			
		int backup = data[minIndex];
			data[minIndex] = data[1];
			data[1] = backup;		
		
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
