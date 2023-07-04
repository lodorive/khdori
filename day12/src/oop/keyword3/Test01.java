package oop.keyword3;

public class Test01 {
	public static void main(String[] args) {
		//static 메소드는 크래스명으로 직접 호출이 가능
		int result = Calculator.plus(10, 20);
		System.out.println("result = "+result);
	}
}
