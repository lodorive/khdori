package oop.getter1;

public class Student {
	String name;
	int korean, english;
	//setter 메소드 - 값을 설정하는 메소드(+조건)
	void setName(String name) {
		this.name = name;
	}
	void setKorean(int korean) {
		this.korean = korean;
	}
	void setEnglish(int english) {
		this.english = english;
	}
	//getter 메소드 - 설정된 값을 반환하는 메소드
	// - 이름은 get + 필드명, 반환형은 필드의 자료형과 같다
	// - 가상의 항목에 대해서 getter 메소드를 만들면 계산을 간소화 할 수 있다
	String getName() {
		return this.name;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getTotal(){
		//return this.total;
		return this.korean + this.english;
	}
	float getAverage() { //get + average
		//return this.average;
		return this.getTotal() / 2f;
	}
	void setup(String name, int korean, int english) {
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
	}	
	void show() {
		System.out.println("<성적 정보>");
		System.out.println("이름: "+this.name); 
		System.out.println("국어 : "+this.korean);
		System.out.println("영어 : "+this.english);
		System.out.println("총점 : "+this.getTotal());
		System.out.println("평균 : "+this.getAverage());		
	}
}
