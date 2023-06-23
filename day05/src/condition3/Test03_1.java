package condition3;

public class Test03_1 {

	public static void main(String[] args) {
		//if 로 풀이
		
		//입력
		int month = 5;
		
		//출력
		if(month == 1 || month == 3 || month == 5 || month == 7 || 
				month == 8 || month == 10 || month == 12) {
			System.out.println("31일");
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11 ) {
			System.out.println("30일");
		}
		else {
			System.out.println("28일");
		}
	}
}
