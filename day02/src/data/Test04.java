package data;

public class Test04 {
	public static void main(String[] args) {
		// 변수를 제대로 사용해서 고치기 쉬운 구조로 만들기
		
		//[1] 문제에서 주어진 값을 먼저 저장
		int a = 7000;
		int b = 8000;
		int c = 2;
		int d = 3;
		
		//[2] 1번의 데이터로 계산
		int e = a * c;
		int f = b * d;
		int g = e + f;
		
		//[3] 1,2번의 데이터로 문제에서 원하는 결과를 출력
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
	}
}
