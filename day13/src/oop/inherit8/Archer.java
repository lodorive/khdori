package oop.inherit8;

public class Archer extends Character{

	public Archer(String id) {
		super(id);
	}

	@Override
	public void attack() {
		System.out.println("궁수가 활로 공격합니다!");
	}

	@Override
	public void move() {
		System.out.println("궁수가 숨어서 이동합니다!");
	}

	@Override
	public void shop() {
		 System.out.println("궁수가 상점을 개설합니다!");
	}

}
