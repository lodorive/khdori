package oop.keyword5;

public class Student {
	//필드에 final 키워드를 붙이면 오류가 난다
	//- 생성과 동시에 초기값으로 잠겨버린다 
	//- 반드시 생성자가 있어야 하며, final 항목에 값을 넣어줘야 한다
	//- final 필드는 setter 메소드 생성이 불가능하다
	private final String name;
	private final int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
