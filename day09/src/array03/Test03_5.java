package array03;

public class Test03_5 {
	public static void main(String[] args) {
		//2차원 반복문으로 출력 (+length)
		
		//data ---> data[0] ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		//	  	  ---> data[1]  ---> [ 0.0f ][ 0.0f ][ 0.0f ]
		
		float[][] data = new float[][] {
		{1.5f, 2.5f, 10.2f},
		{10.2f, 5.2f, 6.5f}
		};
		
		System.out.println(data.length); //2
		System.out.println(data[0].length); //3
		System.out.println(data[1].length); //3
		
		for(int k = 0; k<data.length; k++) {
			for(int i = 0; i<data[k].length; i++) {
				System.out.print(data[k][i] +"\t");
			}
			System.out.println();
		}
	}
}
