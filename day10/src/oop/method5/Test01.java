package oop.method5;

public class Test01 {
	public static void main(String[] args) {
		
		//생성
		Shoppingmall s1 = new Shoppingmall();
		Shoppingmall s2 = new Shoppingmall();
		Shoppingmall s3 = new Shoppingmall();
		Shoppingmall s4 = new Shoppingmall();
		
		//초기화
		s1.setup("참이슬후레쉬", "주류", 1200, true, true);
		s2.setup("클라우드맥주", "주류", 3000, false, true);
		s3.setup("바나나킥", "과자", 1500, false, true);
		s4.setup("허니버터칩", "과자", 2000, true, false);
		
		//출력
		s1.show();
		s2.show();
		s3.show();
		s4.show();
	}
}
