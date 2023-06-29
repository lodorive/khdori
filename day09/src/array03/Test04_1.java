package array03;

public class Test04_1 {
	public static void main(String[] args) {
		//문자열 배열 생성 및 반복문 구현
		
		String[][] data = new String[][] {
		{"자바", "스프링", "안드로이드"},
		{"파이썬", "판다스", "장고"}
		};
		
		for(int k = 0; k<data.length; k++) {
			
			for(int i =0; i<data[k].length; i++) {
				System.out.print(data[k][i]+"\t");
			}
			System.out.println();
		}
	}
}
