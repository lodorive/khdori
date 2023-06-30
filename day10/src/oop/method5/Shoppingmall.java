package oop.method5;

public class Shoppingmall {
	//멤버 필드
	String name;
	String type;
	int price;
	boolean delivery;
	boolean event;
	
	//메소드
	void setup(String name, String type, int price) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.delivery = false;
		this.event = false;		
	}
	void setup(String name, String type, int price, boolean delivery, boolean event) 
	{
		this.name = name;
		this.type = type;
		this.price = price;
		this.delivery = delivery;
		this.event = event;				
	}
	
	void show() {
		System.out.println("<상품 정보>");
		System.out.println("상품명 : "+this.name);
		System.out.println("분류 : "+this.type);
		
		if(this.event) {
			System.out.println("가격 : "+this.price+"원(행사중)");
			System.out.println("행사가 : "+this.price*90/100+"원");
		}
		else{System.out.println("가격 : "+this.price+"원");
		}
		
		if(this.delivery) {
			System.out.println("* 새벽배송 가능(+2500원)");
		}
		else {
			System.out.println("* 새벽배송 불가");
		}
		System.out.println();
	}
}
