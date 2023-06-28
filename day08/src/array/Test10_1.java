package array;

public class Test10_1 {
	public static void main(String[] args) {
		//배열의 주요 계산 방법 - 최대/최소 찾기
		//- data의 가장 큰 값이 얼마인가? 어디있는가?
		//- data의 가장 작은 값이 얼마인가? 어디있는가?
		
		int[] data = new int[] {15,33,58,99,};
		
		//최대값은 [0] 위치가 가장 크다고 가정하고 [1]부터 끝까지 비교하여
		//더 큰 데이터가 나오면 덮어쓰기하여 구한다
		
		int max = data[0]; //배열의 맨 앞에 위치한 데이터를 넣는다
		for(int i = 1; i<data.length; i++) {
				if(max<data[i]) { //더 큰 숫자가 나오면
					max=data[i]; //max를 갈아엎는다
			}
		}		
		
		System.out.println("최대값 = "+max);
	}
}
