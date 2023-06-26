package loop;

public class Test04_1 {
	public static void main(String[] args) {
		//1부터 99 사이에 5가 포함되어 있는 숫자만 필터링하여 출력
		//문제 풀이
		
		for(int i = 1; i <= 99; i++) {
			boolean ten = i / 10 == 5;
			boolean one = i % 10 == 5;
			boolean five = ten || one;
			if(five) {
			System.out.println("i = " + i);
			}
			else {
				//할게없음
			}
		}
	}
}