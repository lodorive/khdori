package oop.inherit1;

public class Test01 {
	public static void main(String[] args) {
		IPhone13 a = new IPhone13();
		a.call();
		a.camera();
		a.siri();
		
		IPhone14 b = new IPhone14();
		b.call();
		b.camera();
		b.facetime();
	}
}
