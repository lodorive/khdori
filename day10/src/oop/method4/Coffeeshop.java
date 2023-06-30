package oop.method4;

public class Coffeeshop {
	//멤버 필드
	String name;
	String type;
	int pay; //할인 전 금액
	boolean event;
	
	//setup을 두 종류로 구현(메소드 오버로딩, method overloading)
	//[1] 3개의 데이터가 들어오면 이벤트는 안하는 걸로 생각하여 처리
	//[2] 4개의 데이터가 들어오면 이벤트 정보도 설정하는 걸로 처리
	void setup(String name, String type, int pay) { //3개의 데이터가 들어오면
		this.name = name;
		this.type = type;
		this.pay = pay;
		this.event = false;
	}
	void setup(String name, String type, int pay, boolean event) { //4개의 데이터가 들어오면
		this.name = name;
		this.type = type;
		this.pay = pay;
		this.event = event;
	}
	
	void show() {
		System.out.println("<커피숍 메뉴>");
		System.out.print("메뉴명 : "+this.name);
		if(this.event) {
			System.out.print("(행사중)");		
			}
		System.out.println();
		
		System.out.println("분류 : "+this.type);
		if(this.event) {
			System.out.print("가격 : "+this.pay*80/100+"원");
			System.out.print("(원가: "+this.pay+"원)");
			System.out.println();
		}
		else {
		System.out.println("가격 : "+this.pay);
		}
		//System.out.println("행사여부 : "+this.event);
		System.out.println();
	}
}
