package loop;

public class Test04 {
	public static void main(String[] args) {
		//1부터 99사이에 5가 포함되어 있는 숫자만 필터링하여 출력
		
		for(int i = 1; i <=99; i++) {
			if(i / 10 == 5){ 
			System.out.println(i);
			}
			else if(i % 10 == 5){
			System.out.println(i);	
			}
		}		
	}
}
