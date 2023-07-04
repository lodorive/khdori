package oop.modifier2_1;

public class Passbook { //적금통장 문제 풀이
	//멤버 필드
	private String name; //이름
	private int year, count, pay, balance; //총기간, 입금회차, 1회 입금액, 잔액
	
	//멤버 메소드
	public void setName(String name) {
		this.name = name;
	}

	public void setYear(int year) {
		switch(year) {
		case 1: case 2: case 3: case 5: case 10:	
		this.year = year;
		}
	}

	public void setCount(int count) {
		if(count < 1) return;
		if(count > this.getTotalCount()) return; //getTotalCount 값을 넘어갈 수 없음
		this.count = count;
	}
	
	public void setPay(int pay) {
		if(pay <= 0) return;
		this.pay = pay; 
	}

	public void setBalance(int balance) {
		if(balance<= 0) return;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public int getYear() {
		return year;
	}
	public int getCount() {
		return count;
	}
	public int getPay() {
		return pay;
	}
	public int getBalance() {
		return balance;
	}
	
	public int getMonth() {
		return this.year * 12;
	}
	
	public int getTotalCount() {
		return this.getMonth() + 1;
	}
	
	//만기인지 아닌지 판정하는 메소드
	//(참고) 논리가 반환값인 Getter 메소드는 get이 아니라 is로 시작하게 작명
	public boolean isFinish() {
		//if(this.getTotalCount() == this.getCount()) {
		//	 return true;
		//}
		//else {
		//	return false;
		//}
		return this.getTotalCount() == this.getCount();
	}
	
	//1개월이 지나면 변하는 것 = 납입횟수, 잔액
	public void next() {
		if(this.isFinish()) return; //만기면 더 이상 x
		
		this.count++; //납입횟수
		this.balance += this.pay; //잔액+입금액 합계
	}
	
	public int getRemainCount() {
		return this.getTotalCount() - this.count;
	}
	//만기 예상 금액 출력
	//현재 잔고 + 남은 횟수(전체횟수-현재횟수)*월부금
	public int getFuture() {
		return this.balance + this.getRemainCount() * this.pay;
	}
	
	//생성자
	public Passbook(String name, int year, int pay) {
		this(name, year, pay, 1, 0);
	}
	
	public Passbook(String name, int year, int count, int pay, int balance) {
		this.setName(name);
		this.setYear(year);
		this.setCount(count);
		this.setPay(pay);
		this.setBalance(balance);
	} 
	
	public void show() {
		System.out.println("<계좌 정보>");
		System.out.println("예금주 : "+this.name);
		System.out.println("예치기간 : "+this.year+"년("+this.getMonth()+"개월)");
		System.out.println("현재납입회차 : ("+this.count+"/"+this.getTotalCount()+")회차");
		System.out.println("월부금 : "+this.pay+"원");
		System.out.println("총잔액 : "+this.balance+"원");
		
		if(this.isFinish()) {
			System.out.println("*해당 적금은 만기되었습니다 *");
		}
		else {
			System.out.println("* 만기 예상 금액 : "+this.getFuture()+"원");
		}
		System.out.println();
	}
}