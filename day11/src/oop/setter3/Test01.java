package oop.setter3;

public class Test01 {
	public static void main(String[] args) {
		Telecom t1 = new Telecom();
		Telecom t2 = new Telecom();
		Telecom t3 = new Telecom();
		Telecom t4 = new Telecom();
		
		t1.setup("갤럭시 23s", "SK", 1800000, 0);
		t2.setup("갤럭시 23s", "KT", 1750000, 24);
		t3.setup("아이폰14", "LG", 2000000, 30);
		t4.setup("아이폰14", "SK", 1990000, 0);
		
		t1.show();
		t2.show();
		t3.show();
		t4.show();
	}
}
