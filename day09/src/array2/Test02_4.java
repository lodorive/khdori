package array2;

public class Test02_4 {
	public static void main(String[] args) {
		//버블 정렬(Bubble sort)
		//- 인접한 두 항목을 비교하여 교체하며 정렬을 수행
		
		//데이터 준비
		int[] data = new int[] {20,10,30,40,50};
		
		//버블 정렬 - k회차(인접한 두 개의 항목을 비교하여 큰 값을 우측으로 이동)
		for(int k=data.length-2; k >= 0; k--) {
			for(int i=0; i <= k; i++) {
				if(data[i] > data[i+1]){
					int backup = data[i];
					data[i] = data[i+1];
					data[i+1] = backup;
				}
			}
		}	
		
		for(int i = 0; i<data.length; i++) {
			System.out.print(data[i]);
			System.out.print("\t");
		}
		System.out.println();
	}
}

