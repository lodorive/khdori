package loop3;

public class Test01 {
	public static void main(String[] args) {
		//while 반복문
		//= 횟수를 모를 때 사용
		//= 종료 시점을 알 때 사용
		
		//ex : for구문과 비교(1부터 10까지 출력)
		for(int i=1; i<=10; i++) {
			System.out.println("for = " +i);
		}
		
		int n = 1; //선언부(while문 밖에 있음)
		
		while(n <= 10) { //조건부
			System.out.println("while = "+n);
			n++; //증감부
		}
	}
}
