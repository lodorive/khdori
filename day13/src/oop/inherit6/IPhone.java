package oop.inherit6;

public class IPhone extends Phone{
	
	//생성자
	public IPhone(String number, String color) {
		super(number,color);
	}
	
	//아이폰 공통기능
	public void siri() {
		System.out.println("IPhone 음성인식 기능 실행");
	}
}
