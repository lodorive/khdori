package loop2;

public class Test02 {
	public static void main(String[] args) {
		// 1부터 99 사이의 숫자 중 7이 포함된 숫자의 개수를 구하여 출력
		// 카운트를 세려면 출력이 가능해야 한다
		
		int count = 0;
		
		for(int i = 1; i <=99; i++){
			boolean ten = i / 10 == 7;
			boolean one = i % 10 == 7;
			if(ten || one) {
				count++;
			}			
		}
		System.out.println("7이 들어간 수는 " +count+ "개 입니다");
	}
}
