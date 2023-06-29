package array;

public class Test13 {
	public static void main(String[] args) {
		//배열의 위치를 완전히 반대로 뒤집어라
		
		int[] data = new int[] {30,50,20,10,40};
		
		int backup = data[0];
		data[0] = data[4];
		data[4] = backup;
		backup = data[1];
		data[1] = data[3];
		data[3] = backup;		
		
		for(int i = 0; i<data.length; i++) {
			System.out.println(data[i]);
		}		
	}
}
