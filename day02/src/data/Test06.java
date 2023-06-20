package data;

public class Test06 {
	public static void main(String[] args) {
		// 영화관 금액 계산 문제
		
		// 입력
		int adultPrice = 15000;
		int teenPrice = 12000;
		int childPrice = 5000;
	
		int adultCount = 2;
		int teenCount = 2;
		int childCount = 0;
	
		//계산
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		int childTotal = childPrice * childCount;
	
		int allTotal = adultTotal + teenTotal + childTotal;
		
		//출력
		System.out.println(allTotal);
	}
}
