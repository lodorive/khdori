package oop.keyword3;

//문제점
//[1] 내부 구조가 복잡함 - 필드를 제거
//[2] 객체를 꼭 만들어야 함 - static 키워드를 추가
public class Calculator {
	//static 키워드가 붙은 메소드는 객체 생성 없이도 호출 가능(메모리에 고정)
	public static int plus(int left, int right) {
		return left + right;
	}
}
