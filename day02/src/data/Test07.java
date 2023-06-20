package data;

public class Test07 {
	public static void main(String[] args) {
		
		int adultPrice = 1200 , adultCount = 2;
		int teenPrice = 1000 , teenCount = 0;
		int childPrce = 500 , childCount = 1;

		//계산 
		int adultTotal = adultPrice * adultCount;
		int teenTotal = teenPrice * teenCount;
		int childTotal = childPrce * childCount;
		
		int allTotal = adultTotal + teenTotal + childTotal;
	
		// 출력
		System.out.println(allTotal);
	}
}
