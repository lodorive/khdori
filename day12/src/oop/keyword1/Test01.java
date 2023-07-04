package oop.keyword1;

public class Test01 {
	public static void main(String[] args) {
		//10 + 20을 객체지향 방식으로 처리
		 Calculator a = new Calculator(10,20);
		 int result = a.getTotal();
		 System.out.println("result = " + result);
	}
}
