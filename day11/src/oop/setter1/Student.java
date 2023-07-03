package oop.setter1;

public class Student {
	
		String name;
		int score;
		
	void setup(String name, int score) {
			this.setName(name); //내가 가진 setName 메소드에 name을 전달하며 호출
			this.setScore(score); //내가 가진 setScore 메소드에 score을 전달하며 호출
		}
		
	void show() {
			System.out.println(this.name);
			System.out.println(this.score);
		}
	
	//필드를 하나씩 변경할 수 있는 메소드를 구현(Setter 메소드)
	// - set+필드명으로 이름 짓는다
	// - 설정 외에 다른 작업을 하지 않는다
	// - (중요) 올바른 데이터만 설정 가능하도록 필터링 처리를 한다
	void setName(String name) {
		switch(name) {// 문자열은 비교를 switch로 한다(if로 하는 방법은 나중에)
		case "피카츄":
		case "라이츄":		
			this.name = name;
		}
	}
	
		void setScore(int score) {
			if(score >= 0 && score <=100) {
			this.score = score;
			}
	}
}
