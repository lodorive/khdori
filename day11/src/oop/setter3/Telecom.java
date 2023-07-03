package oop.setter3;

public class Telecom {
	String name; //이름
	String agency; //통신사
	int price; //가격
	int months; //개월수
	
	void setName(String name) {
		this.name = name;
	}
	
	void setAgenncy(String agency) {
		switch(agency){
		case "SK":
		case "KT":
		case "LG":
			this.agency = agency;
		}
	}
	void setPrice(int price) {
		if(price < 0) {
			return;
		}
		this.price = price;
		}
	void setMonths(int months) {
		switch(months) {
		case 0: case 24: case 36:
			this.months = months;
		}
	}
	void setup(String name, String agency, int price) {
		this.setup(name, agency, price, 0);
	}
	void setup(String name, String agency, int price, int months) {
		setName(name);
		setAgenncy(agency);
		setPrice(price);
		setMonths(months);
	}
	
	void show() {
			System.out.println("<휴대폰 정보>");
			System.out.println("이름 : "+this.name);
			System.out.println("통신사 : "+this.agency);
		
		if(this.months ==0) {
			int discount = this.price * 5 / 100;
			int result = this.price - discount;
			System.out.println("판매가 : "+result+"원");
			System.out.println("(원가 " + this.price +"원)");
		}
		else {
			int monthsPrice = this.price/this.months;
			System.out.println("판매가 : "+this.price+"원");
			System.out.println("(월 "+monthsPrice+"원)");
		}
		if(this.months == 0) {
			System.out.println("약정 없음");
		}
		else {
			System.out.println("약정기간 : "+this.months+"개월");
		}
			System.out.println();
	}
}
