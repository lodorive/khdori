package oop.test3;

public class Test01 {
	public static void main(String[] args) {
		//생성
		WorldCup a = new WorldCup();
		WorldCup b = new WorldCup();
		WorldCup c = new WorldCup();
		WorldCup d = new WorldCup();
		
		//초기화
		a.rank = 1;
		a.name = "킬리안 음바페";
		a.nation = "프랑스";
		a.goal = 8;
		
		b.rank = 2;
		b.name = "리오넬 메시";
		b.nation = "아르헨티나";
		b.goal = 7;
		
		c.rank = 3;
		c.name = "올리비에 지루";
		c.nation = "프랑스";
		c.goal = 4;
		
		d.rank = 4;
		d.name = "훌리안 알바레스";
		d.nation = "아르헨티나";
		d.goal = 4;
		
		
		//출력
		System.out.print("순위 : "+a.rank+"\t");
		System.out.print("이름 : "+a.name+"\t");
		System.out.print("국가 : "+a.nation+"\t");
		System.out.println("득점 : "+a.goal);
		
		System.out.print("순위 : "+b.rank+"\t");
		System.out.print("이름 : "+b.name+"\t");
		System.out.print("국가 : "+b.nation+"\t");
		System.out.println("득점 : "+b.goal);
		
		System.out.print("순위 : "+c.rank+"\t");
		System.out.print("이름 : "+c.name+"\t");
		System.out.print("국가 : "+c.nation+"\t");
		System.out.println("득점 : "+c.goal);
		
		System.out.print("순위 : "+d.rank+"\t");
		System.out.print("이름 : "+d.name+"\t");
		System.out.print("국가 : "+d.nation+"\t");
		System.out.println("득점 : "+d.goal);
	}
}
