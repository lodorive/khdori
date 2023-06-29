package array03;

public class Test03 {
	public static void main(String[] args) {
		//2차원 실수 배열 생성 및 출력
		
		//data ---> data[0] ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		//	  	  ---> data[1]  ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		
		float[][] data = new float[2][3];
		data[0][0] = 1.5f;
		data[0][1] = 2.5f;
		data[0][2] = 3.6f;
		data[1][0] = 10.2f;
		data[1][1] = 5.3f;
		data[1][2] = 6.5f;
	
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
