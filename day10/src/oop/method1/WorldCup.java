package oop.method1;

public class WorldCup {
	//멤버 필드(멤버 변수) - 데이터
	int rank;
	String name;
	String nation;
	int goal;	
	
	//멤버 메소드 - 공통코드 
	//void 이름(){코드}
	
	//출력용
	void show() { 
		//this = 클래스의 멤버를 의미(내꺼)
		System.out.println("<선수 득점 정보>");
		System.out.print("순위 : "+this.rank+"\t");
		System.out.print("이름 : "+this.name+"\t");
		System.out.print("국가 : "+this.nation+"\t");
		System.out.println("득점 : "+this.goal);
	}
	
	//초기화용
	//설정될 값을 알 수 없으므로 외부에서 전달받아서 초기화
	//매개변수(매개가 되는 변수)
	void setup(int rank, String name, String nation, int goal) {
		this.rank = rank;
		this.name = name;
		this.nation = nation;
		this.goal = goal;
	}
}
