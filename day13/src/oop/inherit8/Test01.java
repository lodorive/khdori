package oop.inherit8;

public class Test01 {
	public static void main(String[] args) {
		
		Warrior w = new Warrior("warrior");
		w.show();
		w.attack();
		w.move();
		w.shop();
		
		Magician m = new Magician("magiccian");
		m.show();
		m.attack();
		m.move();
		m.shop();
		
		Archer a = new Archer("archer");
		a.show();
		a.attack();
		a.move();
		a.shop();
	}
}
