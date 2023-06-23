package loop;

public class Test05 {
	public static void main(String[] args) {
		//1부터 99 사이에 369게임에서 박수치는 숫자만 필터링하여 출력
		
		for(int i = 1; i <=99; i++) {
			if(i / 10 == 3 || i == 6 || i == 9){ 
			System.out.println(i);
			}
			else if(i % 10 == 3 || i == 6 || i == 9){
				System.out.println(i);	
			}
		}		
	}
}
