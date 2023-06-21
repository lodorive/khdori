package data2;

public class Test03 {
	public static void main(String[] args) {
		
		//kh주유소 휘발유 1L 1530원 50000원 주유시 휘발유의 양
		
		//입력
		int unitPrice = 1530;
		int money = 50000;
		
		//계산
		//double liter = money / unitPrice;
		double liter = (double) money / unitPrice;
		
		//출력
		System.out.println(liter);
	}
}