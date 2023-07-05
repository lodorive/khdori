package oop.inherit4;

public class Test01 {
	public static void main(String[] args) {
		
		Mp4 m1 = new Mp4();
		m1.setFilename("상속.mp4");
		m1.setFilesize(100000L);
		m1.setSpeed(1.2f);
		m1.execute();
		m1.forward();
		m1.rewind();
		
		Mp3 m2 = new Mp3();
		m2.setFilename("자바의정석.mp3");
		m2.setFilesize(10000L);
		m2.setDuration(180);
		m2.execute();
		m2.forward();
		m2.rewind();
		
		Hwp h = new Hwp();
		h.setFilename("시험필기.hwp");
		h.setFilesize(999L);
		h.setPagesize(20);
		h.execute();
		h.preview();
		
		Ppt p = new Ppt();
		p.setFilename("발표자료.ppt");
		p.setFilesize(12345L);
		p.setPagesize(150);
		p.execute();
		p.slideShow();
		
	}
}
