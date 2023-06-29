package array;

public class Test13_1 {
	public static void main(String[] args) {
		//다섯 칸일 때만 통하는 방법 풀이
		
		int[] data = new int[] {30,50,20,10,40};
		
		//[0]과 [4]를 교체
		int backup = data[0];
		data[0] = data[4];
		data[4] = backup;
		
		//[1]과 [3]을 교체
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;				
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
