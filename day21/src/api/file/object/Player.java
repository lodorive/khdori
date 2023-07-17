package api.file.object;

import java.io.Serializable;

//캐릭터 클래스
//= 입출력이 가능하도록 마킹 처리
public class Player implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private int level;
	private int gold;

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
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		if(gold < 0) return;
		this.gold = gold;
	}

	public Player(String id) {
		this.setId(id);
		this.setLevel(1);
		this.setGold(0);
	}

	public void show() {
		System.out.println("<캐릭터 정보>");
		System.out.println("아이디 : " + this.id);
		System.out.println("레벨 : " + this.level);
		System.out.println("소지금 : " + this.gold + " gold");
	}

	public void levelUp() {
		this.level ++;
	}

}

