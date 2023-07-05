package oop.inherit8;

//추상클래스가 되면 (1) 객체 생성 금지 (2) 추상 메소드 작성 가능
public abstract class Character {
	//공통필드
	private String id;
	private int level;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		if(level < 1) return;
		this.level = level;
	}
	
	//생성자 - 오직 아이디만 설정
	public Character(String id) {
		this.setId(id);
		this.setLevel(1);
	}
	//공통메소드
	public abstract void attack();
	public abstract void move();
	public abstract void shop();
	
	//출력메소드
	public final void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : "+this.id);
		System.out.println("레벨 : "+this.level);
	};
	
}
