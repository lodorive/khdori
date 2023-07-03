package oop.getter2;

public class Grade {
	//멤버 필드
	String name; //이름
	int year, korean, english, math; //학년, 국어, 영어, 수학
	
	//멤버 메소드
	void setName(String name) {
		this.name = name;
	}
	void setYear(int year) {
		if(year >= 1 && year <=6) {
		this.year = year;
		}
	}
	void setKorean(int korean) {
		if(korean >= 0 && korean <=100)
		this.korean = korean;
	}
	void setEnglish(int english) {
		if(english <0 || english >100) return; //위와 같은 의미
		this.english = english;
	}
	void setMath(int math) { //위와 같은 의미 골라서 사용
		if(!(math >= 0 && math <=100)) return;
		this.math = math;
	}
	
	
	String getName() {
		return this.name;
	}
	int getYear() {
		return this.year;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	int getTotal() {
		//return this.korean + this.english + this.math;
		return this.getKorean() + this.getEnglish() + this.getMath();
	}
	double getAverage() {
		return this.getTotal() / 3d;
	}
	
	String getGrade() {
		double average = this.getAverage();
		if(average >= 90) 
			return "A";	
		else if(average >= 80) 
			return "B";	
		else if(average >= 70) 
			return "C";	
		else 
			return "F";
	}

	void setup(String name, int year, int korean, int english, int math) {
		this.setName(name);
		this.setYear(year);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	void show() {
		System.out.println("<학생 성적 정보>");
		System.out.println("이름 : "+this.name);
		System.out.println("학년 : "+this.year);
		System.out.println("국어 점수 : "+this.korean);
		System.out.println("영어 점수 : "+this.english);
		System.out.println("수학 점수 : "+this.math);
		System.out.println("총점 : "+this.getTotal());
		System.out.println("평균 : "+this.getAverage());
		System.out.println("등급 : "+this.getGrade());
		System.out.println();
	}
}
