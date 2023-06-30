package oop.method5;

public class Test01 {
	public static void main(String[] args) {
		
		//생성
		Payment p1 = new Payment();
		Payment p2 = new Payment();
		Payment p3 = new Payment();
		
		//초기화
		p1.setup("SK", "5G언택트 52", 52000, 200, 1000, 2000);
		p2.setup("KT", "5G세이브", 45000, 100, 900, 1500);
		p3.setup("LG", "5G시그니처", 130000, 500, 2000, 2500);
		
		//출력
		p1.show();
		p2.show();
		p3.show();
	}
}
