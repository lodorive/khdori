package oop.inherit6;

public class Galaxy23s extends Galaxy{
	public Galaxy23s(String number, String color) {
		super(number,color);
	}	
	
	//고유기능
	public void bixby() {
		System.out.println("갤럭시23s 음성인식 기능 실행");
	}
	
	//마음에 안드는 기능을 재정의(override)
	public void call() {
		System.out.println("갤럭시23s 전화 기능 실행");
	}
	public void sms() { 
		System.out.println("갤럭시23s 문자 기능 실행");
	}
	
	public void samsungPay() {
		System.out.println("갤럭시23s 삼성페이 기능 실행");
	}	
}
