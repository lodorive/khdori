package array03;

public class Test04 {
	public static void main(String[] args) {
		//문자열 배열 생성 및 반복문 구현
		
		String[][] data = new String[2][3];
		data[0][0] = "자바";
		data[0][1] = "스프링";
		data[0][2] = "안드로이드";
		data[1][0] = "파이썬";
		data[1][1] = "판다스";
		data[1][2] = "장고";
		
		System.out.println(data[0][0]);
		System.out.println(data[0][1]);
		System.out.println(data[0][2]);
		System.out.println(data[1][0]);
		System.out.println(data[1][1]);
		System.out.println(data[1][2]);		

	}
}
