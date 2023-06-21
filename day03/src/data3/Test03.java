package data3;

public class Test03 {
	public static void main(String[] args) {
		//이 숫자가 짝수인지 판정하여 출력
		
		//입력
		int number = 17;
		
		//계산
		//int mod = number % 2;
		//boolean zero = mod가 0과 같습니까?
		//boolean zero = mod == 0;
		boolean even = number % 2 == 0;

		//출력
		System.out.println(even);		
	}
}
