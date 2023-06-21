package data2;

public class Test02 {
	public static void main(String[] args) {
		// 키 180cm, 몸무게 80kg의 BMI 지수 구하기
		// 입력
		int cm = 180;
		int kg = 80;

		//int m = cm / 100;
		//double m = cm/100d;	
		double m = (double)cm / 100;
		
		//계산
		double bmi = kg / (m * m);
		
		//출력
		System.out.println(bmi);
	}
}