package oop.method3;

public class Payment {
	
	String telecom;
	String name;
	int pay;
	int gb;
	int call;
	int message;
	
	void setup(String telecom, String name, 
			int pay, int gb, int call, int message) {
		this.telecom = telecom;
		this.name = name;
		this.pay = pay;
		this.gb = gb;
		this.call = call;
		this.message = message;
	}
	void show() {
		System.out.println("<통신사 요금제 정보>");
		System.out.println("통신사 : "+this.telecom);
		System.out.println("상품명 : "+this.name);
		System.out.println("월정액 : "+this.pay);
		System.out.println("데이터(GB) : "+this.gb);
		System.out.println("통화(분) : "+this.call);
		System.out.println("문자(건) : "+this.message);
		System.out.println();
	}
}
