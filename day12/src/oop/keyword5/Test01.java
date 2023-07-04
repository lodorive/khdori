package oop.keyword5;

public class Test01 {
	public static void main(String[] args) {
		//불변 처리(final)
		//- 변수는 하나의 값만 저장이 가능하며, 대입하면 값을 덮어쓰기한다
		//- 최초 이후의 대입을 금지하고 싶다면 final 키워드를 추가 
		//- 값의 변경을 원천봉쇄하기 위해서 사용
		
		//int a = 10;
		final int a;
		a = 10;
		//a = 20; //금지(error)
		//a = 30; //금지(error)
		
		System.out.println("a = "+a);
	}
}
