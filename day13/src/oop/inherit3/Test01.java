package oop.inherit3;

public class Test01 {
	public static void main(String[] args) {
		//Browser는 생성하면 안된다(상속의 의미가 없어짐)
		Chrome c = new Chrome();
		c.setUrl("https://www.google.com");
		c.refresh();
		c.move();
		c.develop();
		c.chromeStore();
		
		Edge e = new Edge();
		e.setUrl("www.microsoft.com");
		e.refresh();
		e.move();
		e.fullScreen();
		
		Whale w = new Whale();
		w.setUrl("https://whale.naver.com");
		w.refresh();
		w.move();
		w.papago();
		w.naverSearch();
	}
}
