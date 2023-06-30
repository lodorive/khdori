package oop.method2;

public class Olympic {
	//멤버 필드(멤버 변수) - 데이터
	String name;
	String event;
	String type;
	int gold;
	int silver;
	int bronze;
	
	//멤버 메소드 - 코드 
	void setup(String name, String event, String type, int gold, int silver, int bronze) {
		this.name = name;
		this.event = event;
		this.type = type;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze; 
	}
	
	void show() {
		System.out.println("<메달리스트 정보>");
		System.out.println("이름 : "+this.name);
		System.out.println("종목 : "+this.event);
		System.out.println("구분 : "+this.type);
		System.out.println("금 "+this.gold+" 은 "+this.silver+" 동 "+this.bronze);
		System.out.println();
	}
}
