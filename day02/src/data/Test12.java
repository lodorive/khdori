package data;

public class Test12 {
	public static void main(String[] args) {
		//1+1 판매 문제
		
		//입력
		int price = 1400;
		int count = 5;
		
		//계산
		int free = count / 2; //무료개수
		int pay = count - free; //유료개수
		int total = price * pay;
		
		//출력
		System.out.println(free);
		System.out.println(total);
	}
}
