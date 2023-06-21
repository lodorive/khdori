package data;

public class Test15 {
	public static void main(String[] args) {
		// KH여행사 할인 금액 구하기
		
		//입력
		int people = 3;
		int days = 7;
		int dayPrice = 100000;
		int rate = 25;
		
		//계산
		int price = people * days * dayPrice; //총 비용
		int discount = price * rate / 100; //할인 금액
		int result = price - discount; //총비용-할인금액
		//int result = price * 75 / 100; 
	
		
		//출력
		System.out.println(result);
	}
}
