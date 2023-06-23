package loop;

public class Test03_1 {
	public static void main(String[] args) {
		//1부터 100사이의 홀수를 출력하는 프로그램을 구현
		//횟수로 처리하기 어려우므로 범위를 정해서 처리
		
		//for(1부터 99까지 2씩 늘어나도록)
		for(int i = 1; i <=100; i++) {
			if(i % 2 == 1) { //i가 홀수면
				System.out.println(i); 
			}
		}		
	}
}
