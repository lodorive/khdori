package array2;

public class Test02 {
	public static void main(String[] args) {
		//버블 정렬(Bubble sort)
		//- 인접한 두 항목을 비교하여 교체하며 정렬을 수행
		
		//데이터 준비
		int[] data = new int[] {30,50,20,10,40};
		
		//버블 정렬 - 1회차(인접한 두 개의 항목을 비교하여 큰 값을 우측으로 이동)
		//[0] vs [1] / [1] vs [2] / [2] vs [3] / [3] vs [4]
		
		if(data[0] > data[1]);{
			int backup = data[0];
			data[0] = data[1];
			data[1] = backup;
		}
		
		if(data[1]>data[2]) {
			int backup = data[1];
			data[1] = data[2];
			data[2] = backup;
		}
		
		if(data[2]>data[3]) {
			int backup = data[2];
			data[2] = data[3];
			data[3] = backup;
		}
		
		if(data[3]>data[4]) {
			int backup = data[3];
			data[3] = data[4];
			data[4] = backup;
		}
			
		
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}

