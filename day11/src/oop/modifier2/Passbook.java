package oop.modifier2;

public class Passbook {

	private String name;
	private int days, round, pay, balance;
	

	public void setName(String name) {
		this.name = name;
	}

	public void setDays(int days) {
		switch(days) {
		case 1:
		case 2:
		case 3:
		case 5:
		case 10:	
		this.days = days;
		}
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	public void setPay(int pay) {
		this.pay = pay; 
	}

	public void setBalance(int balance) {
		if(balance< 0) {
			return;
		}
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public int getDays() {
		return days;
	}
	public int getRound() {
		return round;
	}
	public int getPay() {
		return pay;
	}
	public int getBalance() {
		return balance;
	}
	
	public String getLast() {
		if(this.getRound() >= this.days * 12 + 1) {
			 return "(만기)";
		}
		else {
			return "";
		}
	}
	
	public int getExpect() {
		return (this.days*12+1)*this.pay;
	}
	
	public Passbook(String name, int days, int round) {
		this(name, days, 1, round, 0);
	}
	
	public Passbook(String name, int days, int round, int pay, int balance) {
		this.setName(name);
		this.setDays(days);
		this.setRound(round);
		this.setPay(pay);
		this.setBalance(balance);
	} 
	
	public void show() {
		System.out.println("<가입자 정보>");
		System.out.println("예금주 : "+this.getName());
		System.out.println("총납입기간 : "+this.getDays()+"년");
		System.out.println("현재납입회차 : "+this.getRound()+getLast()+"회차");
		System.out.println("월납입금액 : "+this.getPay()+"만원");
		System.out.println("총잔액 : "+this.getBalance()+"만원");
		System.out.println("예상 만기금액 : "+this.getExpect()+"만원");
		
		System.out.println();
	}
}