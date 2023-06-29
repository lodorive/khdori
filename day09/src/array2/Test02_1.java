package array2;

public class Test02_1 {
	public static void main(String[] args) {
		//버블 정렬(Bubble sort)
		//- 인접한 두 항목을 비교하여 교체하며 정렬을 수행
		
		//데이터 준비
		int[] data = new int[] {30,50,20,10,40};
		
		for(int i =0; i<4; i++) {
	
			if(data[i] > data[i+1]);{
				int backup = data[i];
				data[i] = data[i+1];
				data[i+1] = backup;
			}
	}
		
				
			for(int i = 0; i<data.length; i++) {
				System.out.println(data[i]);
		}
	}
}

