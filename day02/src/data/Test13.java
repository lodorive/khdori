package data;

public class Test13 {
	public static void main(String[] args) {
		
		//입력
		int coffe = 2500;
		int coffeCount = 28;
		
		//계산
		int coffeFree = coffeCount / 6;
	    int coffeBuy = coffeCount - coffeFree;
	    
	    int totalPrice = coffe * coffeBuy;
	    
	    System.out.println(coffeFree);
	    System.out.println(totalPrice);
	}
}
