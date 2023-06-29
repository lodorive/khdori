package array03;

public class Test03_1 {
	public static void main(String[] args) {
		
		float[][] data = new float[2][3];
				
		data[0][0] = 1.5f;
		data[0][1] = 2.5f;
		data[0][2] = 3.6f;
		data[1][0] = 10.2f;
		data[1][1] = 5.3f;
		data[1][2] = 6.5f;
		
		for(int k = 0; k<2; k++) {
						for(int i = 0; i<3; i++) {
				System.out.println(data[k][i]);
			}
		}
		
	}
}
