package array03;

public class Test03_3 {
	public static void main(String[] args) {
		//2차원 반복문으로 출력
		
		//data ---> data[0] ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		//	  	  ---> data[1]  ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		
		float[][] data = new float[][] {
		{1.5f, 2.5f, 10.2f},
		{10.2f, 5.2f, 6.5f}
		};
		
		for(int i = 0; i<3; i++) {
		System.out.print(data[0][i] +"\t");
		}
		System.out.println();
		
		for(int i =0; i<3; i++) {
		System.out.print(data[1][i]+"\t");
		}	
		System.out.println();
	}
}
