package oop.inherit6;

public class IPhone13  extends IPhone {
	public IPhone13 (String number, String color) {
		super(number,color);
	}
	
	//고유기능
	public void itunes() {
		System.out.println("IPhone13 아이튠즈 기능 실행");
	}
	
	//재정의
	public void call() {
		System.out.println("IPhone13 전화 기능 실행");
	}
	public void sms() { 
		System.out.println("IPhone13 문자 기능 실행");
	}
	public void siri() {
		System.out.println("IPhone13 음성인식 기능 실행");
	}
}
