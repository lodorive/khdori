package oop.inherit7;

//추상클래스를 상속 받으면 추상메소드를 해결(재정의) 해야 한다
public class Galaxy23s extends Galaxy{

	public Galaxy23s(String number, String color) {
		super(number, color);
	}

	@Override
	public void samsungPay() {

	}

	@Override
	public void call() {
		
	}

	@Override
	public void sms() {
		
	}
	
	//고유기능
	public void bixby(){		
	}

}
