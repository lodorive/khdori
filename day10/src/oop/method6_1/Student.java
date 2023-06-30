package oop.method6_1;

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
	
	//(문제점) show에서 너무 많은 일을 하고 있음
	//(해결책) 계산을 메소드가 할 수 있도록 추가 메소드 생성
	
	//[1] 총점을 구해주는 메소드
	//(참고) return 키워드는 "반환" 과 "종료" 의 의미를 가지는 키워드
	//(참고) void 키워드는 "결과물이 없음" 이란 의미를 가지는 키워드
	int getTotal() {
		return this.korean + this.english + this.math;
	}
	
	//[2] 평균을 구해주는 메소드
	float getAverage() {
		return this.getTotal()/3f;
	}
	
	//[3] 합격/불합격을 판정하는 메소드
	boolean getPass() {
		return this.korean >=40  && this.english >=40
				&&  this.math >=40&& this.getAverage()>=60;
	}
	
	void show() {
		System.out.println("<성적 정보>");
		System.out.println(this.level+"학년  "+this.group+"반 "+" 이름 : "+this.name);
		
		System.out.println("국어 : "+this.korean+"점");
		System.out.println("영어 : "+this.english+"점");
		System.out.println("수학 : "+this.math+"점");
			
		System.out.println("총점 : "+this.getTotal()+"점");	
		System.out.println("평균 : "+this.getAverage()+"점");
		
		if(this.getPass()) {
			System.out.println("* 통과");
		}
		else {System.out.println("* 재평가 대상");
		}
		System.out.println();
	}
}
