package array03;

public class Test03_2 {
	public static void main(String[] args) {
		//2차원 실수 배열 생성+초기화 및 출력
		
		//data ---> data[0] ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		//	  	  ---> data[1]  ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		
		float[][] data = new float[][] {
		{1.5f, 2.5f, 10.2f},
		{10.2f, 5.2f, 6.5f}
		};
	
		System.out.print(data[0][0] +"\t");
		System.out.print(data[0][1]+"\t");
		System.out.print(data[0][2]+"\t");
		System.out.println();
		
		System.out.print(data[1][0]+"\t");
		System.out.print(data[1][1]+"\t");
		System.out.print(data[1][2]+"\t");		
		System.out.println();
	}
}
