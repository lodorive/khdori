package oop.inherit2;

//하위 클래스, 자식 클래스, 구현체
//= 실제 객체를 생성하기 위해 만드는 클래스
//= extends라는 키워드로 클래스를 지정하여 내용을 가져올 수 있음
public class IPhone13 extends IPhone {
	//필드 - 3개(상속받은것)
	//메소드 - 2개(상속받은것) + 1개(고유기능)
	public void siri() {
		System.out.println("시리야");
	}
}
