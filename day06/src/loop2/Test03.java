package loop2;

public class Test03 {
	public static void main(String[] args) {
	// 1부터 99 사이의 숫자 중 369게임에서 박수치는 숫자의 개수를 구하여 출력
		
		int count = 0;
		
		for(int i = 1; i <= 99; i++){
			boolean ten = i / 10 == 3 || i / 10 == 6 || i / 10 == 9;
			boolean one = i % 10 == 3 || i % 10 == 6 || i % 10 == 9;
			
			if(ten || one) {
				count++;
			}
		}
		System.out.println("박수치는 숫자의 개수는 "+count+ "개 입니다");
	}
}
