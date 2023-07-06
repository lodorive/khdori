package oop.multi2;

public class Test01 {
	public static void main(String[] args) {
		Drone d = new Drone();
		//Flyable d = new Drone(); //업캐스팅
		//Electronic d = new Drone(); //업캐스팅
		//Transportation d = new Drone(); //업캐스팅
		
		d.on();
		d.move();
		d.fly();
		d.off();
		
		Airplane a = new Airplane();
		a.move();
		a.fly();
		a.reservation();
		
		Train t = new Train();
		t.move();
		t.reservation();
		
		Bus b = new Bus();
		b.move();
		
		Kickboard k = new Kickboard();
		k.on();
		k.move();
		k.off();
		
		Transportation tt = d; //업캐스팅
		
		//-----------------------------------
		if(tt instanceof Drone) {		
			//Dorne dd = tt; //다운캐스팅(에러)
			Drone dd = (Drone)tt; //다운캐스팅(ok)
			
			dd.on();
		}
		
	}
}
