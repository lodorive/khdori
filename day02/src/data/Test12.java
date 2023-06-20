package data;

public class Test12 {
	public static void main(String[] args) {
		
		//입력
		int gimbapPrice = 1400;
		int gimbapCount = 5;
		
		int gimbapEvert = gimbapCount / 2;
		
		int gimbapFree = gimbapCount - gimbapEvert;
		int totalPrice = gimbapFree * gimbapPrice;

		System.out.println(gimbapEvert);
		System.out.println(totalPrice);
	}
}
