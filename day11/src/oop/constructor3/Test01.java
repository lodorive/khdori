package oop.constructor3;

public class Test01 {
	public static void main(String[] args) {
		
		Game g1 = new Game("헤라클래스","전사",50);
		Game g2 = new Game("포세이돈","마법사",20);
		Game g3 = new Game("아프로디테","마법사",1);
		
		g1.show();
		g2.show();
		g3.show();
	}
}
