package loop2;

public class Test06 {
	public static void main(String[] args) {
		//누적 합계 구하기
		
		//[Q1] 10을 10번 더하면 얼마?
		int total = 0;
		
		for(int i = 0; i < 10; i++) {
			total += 10;
		}
		System.out.println(total);
		
		//[Q2] 1부터 10까지 더하면 얼마?
		int total2 = 0;
		
		for(int i = 1; i <= 10; i++) { 
			total2 += i; //내가 만든 값을 더하겠다
		}
		System.out.println(total2);
	}
}
