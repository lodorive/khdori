package array;

public class Test13_2 {
	public static void main(String[] args) {
		//몇 칸이든 통하는 방법
		//= 바꾸는 횟수는 데이터 개수의 절반과 같다
		
		int[] data = new int[] {30,50,20,10,40,10,20,30};
		
		for(int i = 0; i<data.length/2; i++) {//절반만큼
			int left = i; //왼쪽위치
			int right = data.length-1-left; //오른쪽위치(갯수-1-왼쪽)
			
			int backup = data[left];
			data[left] = data[right];
			data[right] = backup;
		}
		
		for(int i=0; i<data.length; i++) {
			System.out.println(data[i]);
		}
	}
}
