package oop.modifier2_1;

public class Test01 {
	public static void main(String[] args) {
		
		Passbook p1 = new Passbook("유재석",3,15,1000000,15000000);
		Passbook p2 = new Passbook("강호동",2,5,500000,2500000);
		Passbook p3 = new Passbook("신동엽",2,8,800000,10000000);
		
		p1.next();

		p1.show();
		p2.show();
		p3.show();
		
	}
}
