package oop.method6;

public class Student {
	//멤버 필드
	int level, group;
	String name;
	int korean, english, math;
	
	//메소드
	void setup(int level, int group, String name, int korean, int english, int math) {
		this.level = level;
		this.group = group;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	void show() {
		System.out.println("<성적 정보>");
		System.out.println(level+"학년  "+group+"반 "+" 이름 : "+name);
		
		System.out.println("국어 : "+korean+"점");
		System.out.println("영어 : "+english+"점");
		System.out.println("수학 : "+math+"점");
		
		int total = this.korean+this.english+this.math;
		System.out.println("총점 : "+total+"점");
		
		float average = total/3f;
		System.out.println("평균 : "+average+"점");
		
		boolean pass = this.korean >=40 
				&& this.english >=40
				&&  this.math >=40
				&& average>=60;

		if(pass) {
			System.out.println("* 통과");
		}
		else {System.out.println("* 재평가 대상");
		}
		System.out.println();
	}
}
