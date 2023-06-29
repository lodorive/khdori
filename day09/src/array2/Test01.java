package array2;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		//정렬(sort)
		//- 여러 개의 데이터를 원하는 목적에 맞게 나열하는 것
		//- 번호순, 이름순, 가격순, 랭킹순, 성적순, 최신순 ...
		//- 번호순이라고 하면 번호가 낮은 것부터 나와야 한다(오름차순ASC)
		//- 성적순이라고 하면 성적이 높은 것부터 나와야 한다(내림차순 DESC)
		//- 정렬 방법은 여러가지가 있으며 상황에 따라 성능이 다르다
		//- 사용자에게 데이터를 효과적으로 보여주기 위한 수단
		
		//데이터 준비
		int[] data = new int[] {30,50,20,10,40};
		
		//선택 정렬 - 1회차(+0부터 +4지점에서 최소값을 찾아 +0지점과 교체)
		int minIndex = 0; // 0번 위치의 값이 제일 작다고 생각
		
		for(int i = 1; i<=4; i++) {//뒤에 있는 데이터와 비교하여
			if(data[minIndex] > data[i]) {//더 작은 값이 있다면
				minIndex = i; //교체!
		}
			}
		System.out.println(minIndex);
			
		int backup = data[minIndex];
			data[minIndex] = data[0];
			data[0] = backup;		
		
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}
