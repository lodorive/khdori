package array03;

public class Test02 {
	public static void main(String[] args) {
		//2차원 배열의 생성과 사용
		
		int[][]score = new int[2][3];
		
		//score ---> score[0] ---> [ 0 ][ 0 ][ 0 ]
		//		   ---> score[1]  ---> [ 0 ][ 0 ][ 0 ]
	
		//초기화
		score[0][1] = 15;
		score[1][0] = 20;
		score[1][2] = 40;
		
		//출력
		System.out.println(score[0][0]); //2차원에서는 뭘하든 2번씩
		System.out.println(score[0][1]);
		System.out.println(score[0][2]);

		System.out.println(score[1][0]);
		System.out.println(score[1][1]);
		System.out.println(score[1][2]);

	}
}