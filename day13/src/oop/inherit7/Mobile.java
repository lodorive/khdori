package oop.inherit7;

//추상 클래스(abstract class)
// = 상속 관계에서 추상적인 개념을 정의하기 위해 만들어진 클래스
// = 부모 클래스
// = 일반 클래스처럼 필드, 메소드, 생성자를 가질 수 있다
// = (중요) 추상 클래스는 추상 메소드를 가질 수 있다
public abstract class Mobile {
	//공통필드
	protected String number;
	protected String color;
	
	//setter&getter 생략
	
	//생성자
	public Mobile(String number, String color) {
		this.number = number;
		this.color = color;
	}
	
	//전화기라면 통화(call)라는 기능이 있어야 한다. 근데 내용은 몰라
	public abstract void call();
	
	//전화기라면 문자(sms)라는 기능이 있어야 한다. 근데 내용은 몰라
	public abstract void sms();
}
