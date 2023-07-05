package oop.inherit5;

public class GalaxyFold4 extends Galaxy{
	//+@
	public void show() {
		System.out.println("<휴대폰 정보>");
		//System.out.println("번호 : "+this.number); //나의번호
		//System.out.println("번호 : "+super.number); //부모클래스의 번호
		System.out.println("번호 : "+number); //this로 처리함
	}
	
	//메소드 재정의(method override)
	// - 상속받은 메소드를 똑같이 한 번 더 만들어서 내가 만든게 실행되도록 하는 것
	// - 뭔가 상속받은 메소드가 맘에 안들 때 사용
	@Override //어노테이션(Annotation) - 역할 부여(해시태그)
	public void call() {
		System.out.println("갤럭시 폴드4의 통화기능 실행!");
	}
	
	//부모클래스에 생성자가 있다면 자식클래스에 생성자가 있어야 한다
	//부모클래스가 필요로 하는 값을 전달해야 한다
	public GalaxyFold4(String color) {
		super(color);
	}
}
