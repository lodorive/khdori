package oop.modifier2;

public class Test01 {
	public static void main(String[] args) {
		Passbook p1 = new Passbook("유재석",3,15,100,1500);
		Passbook p2 = new Passbook("강호동",2,5,50,250);
		Passbook p3 = new Passbook("신동엽",2,8,80,1000);
		
		p1.show();
		p2.show();
		p3.show();
		
	}
}
