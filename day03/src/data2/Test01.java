package data2;

public class Test01 {
	public static void main(String[] args) {
		//실수가 필요한 상황
		//[Q] 국어점수가 75점, 영어점수가 80점일 때 평균
		
		int korean = 75;
		int english = 80;
		
		//int average =  (korean + english) / 2;
		double average = (korean + english) / 2.0;
		
		System.out.println(average);


		//실수는 2가지 종류가 있다
		float a = 3.1455656565223345464648f;
		double b = 3.145664488946464646411; //기본값
		System.out.println(a);
		System.out.println(b);
		
		//실수가 한개라도 있는 계산은 결과가 실수
		System.out.println(10 / 3);
		System.out.println(10 / 3.0);
		System.out.println(10.0 / 3);
		System.out.println(10 / 3f);

	}
}