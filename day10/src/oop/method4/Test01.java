package oop.method4;

public class Test01 {
	public static void main(String[] args) {
		
		//생성
		Coffeeshop c1 = new Coffeeshop();
		Coffeeshop c2 = new Coffeeshop();
		Coffeeshop c3 = new Coffeeshop();
		Coffeeshop c4 = new Coffeeshop();
		
		//초기화
		c1.setup("아메리카노", "음료"	, 2500, true);
		c2.setup("모카라떼", "음료", 3500, false);
		c3.setup("치즈케이크", "디저트", 5000, true);
		c4.setup("마카롱", "디저트", 3000, false);
		
		//출력
		c1.show();
		c2.show();
		c3.show();
		c4.show();
	}
}
