package oop.constructor3;

public class Game {
	String id, jop;
	int level;
	
	void setId(String id) {
		this.id = id;
	}
	void setWork(String jop) {
		switch(jop) {
		case "전사":
		case "마법사":
		case "궁수":
		this.jop = jop;
	}
		}
	void setLevel(int level) {
		if(level <1) return;
		this.level = level;
	}
	
	String getId() {
			return id;		
		}
	
	String getJop() {
			return jop;		
	}
		
	int getLevel() {
			return level;
		}
	
	void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : "+this.id);
		System.out.println("직업 : "+this.jop);
		System.out.println("레벨 : "+this.level);
		System.out.println();
	}
	
	//생성자 - 생성 시 필요한 데이터를 강제하는 도구
	Game(String id, String jop){
		this(id, jop, 1); //레벨이 없으면 1로 생성하세요
	}
	Game(String id, String jop, int level){
		this.setId(id);
		this.setWork(jop);
		this.setLevel(level);
	}
}

