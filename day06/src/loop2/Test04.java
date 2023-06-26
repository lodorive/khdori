package loop2;

public class Test04 {
	public static void main(String[] args) {
		//소수 탐색 프로그램
		//소수는 1이나 자기자신 빼고 나누어 떨어지는 수가 없다는 뜻
		
		int number = 5;
		
		int count = 0;
		
		for(int i = 1; i <= number; i++){
			if(number % i == 0) {
			//System.out.println(number % i);
			count++;
			}
		}
		System.out.println(count);
	
		if(count ==2) {
			System.out.println("소수입니다");
		}
		else {
			System.out.println("소수가 아닙니다");
			}
		}
	}
