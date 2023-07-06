package oop.inherit8;

//두 개의 캐릭터로 서로간의 전투를 하도록 처리하는 클래스
// - ex : 거래 / 전투 / ...
	public class Interaction {
	
	//전투 기능
	public static void battle(Character a,Character b) {
		a.attack();
		b.attack();
	}	
}