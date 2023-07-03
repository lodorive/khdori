package oop.modifier1;

public class Student {
	//필드는 접근을 차단해야 한다(private)
	//- 같은 클래스 내부에서는 접근이 가능해야 한다 
	private String name;			
	private int score;
	
	//필드를 제외한 나머지는 공개(public)
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		if(score < 0 || score > 100)
			return;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	//생성자도 public
	public Student() {} //기본 생성자를 만들면 비어있는 객체를 허용해줌
	public Student(String name, int score) {
		this.setName(name);
		this.setScore(score);
	}
	public void show() {
		System.out.println("<학생정보>");
		System.out.println("이름 : "+this.name);
		System.out.println("점수 : "+this.score);
	}
	
}
