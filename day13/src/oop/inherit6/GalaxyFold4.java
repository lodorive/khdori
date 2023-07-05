package oop.inherit6;

public class GalaxyFold4 extends Galaxy {
	public GalaxyFold4(String number, String color) {
		super(number,color);
	}
	//고유기능
	public void iris() {
		System.out.println("갤럭시폴드4 홍채인식 기능 실행");
	}
	//재정의
	public void call() {
		System.out.println("갤럭시폴드4 전화 기능 실행");
	}
	public void sms() {
		System.out.println("갤럭시폴드4 문자 기능 실행");
	}
	public void samsungPay() {
		System.out.println("갤럭시폴드4 삼성페이 기능 실행");
	}	
}
