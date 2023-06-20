package data;

public class Test09 {
	public static void main(String[] args) {
		//한 달에 200만원씩 30년을 모으면 얼마인지 계산
		//입력
		int money = 2000000;
		int year = 30;
		
		//계산
		int month = year * 12;
		int total = money * month;
		
		System.out.println(total);
	}
}