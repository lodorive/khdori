package oop.constructor2;

public class Test01 {
	public static void main(String[] args) {
		Kpop k1 = new Kpop("그때 그 순간 그대로(그그그)", "WSG워너비",
				"WSG워너비 1집", 104250, 91835);
		Kpop k2 = new Kpop("보고싶었어", "WSG워너비", "WSG워너비 1집",
				83127, 91835);
		Kpop k3 = new Kpop("LOVE DIVE","IVE(아이브)","LOVE DIVE",
				64590, 174519);
		Kpop k4 = new Kpop("POP!","나연(TWICE)","IM NAYEON",
				58826,70313);
		
	k1.show();
	k2.show();
	k3.show();
	k4.show();
	}
}
