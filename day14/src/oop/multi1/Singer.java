package oop.multi1;

//인터페이스
// -다중상속을 위해 만들어진 변형된 클래스
// - 다중상속에 문제가 되는 요소들을 모두 제거
// - super 키워드의 대상이 될 수 없다
public interface Singer {
	//필드 - 일반적인 필드 생성 불가, 상수만 가능(public static final 자동 완성)
	//String name = "아무개";
	
	//메소드 - 추상메소드만 생성 가능
	void sing();
		
	//생성자 - 아예 생성 불가
	//public singer() {}
}
