package condition3;

public class Test03_3 {
	public static void main(String[] args) {
		
		//1월부터 12월은 각각 정해진 날짜 수가 존재한다
		//31일까지 존재하는 달(1, 3, 5, 7, 8, 10, 12)
		//30일까지 존재하는 달(4, 6, 9, 11)
		//28일까지 존재하는 달(2)
		
		//연도를 추가하여 윤년까지 계산되도록 한다
	
		//입력

		
		int year = 2004;
		int month = 2; 
		
		//계산
		int days;
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			days = 31;
		break;
		case 4, 6, 9, 11:
			days = 30;
		break;
		default:
			boolean leapYear = year % 400 == 0 || year % 4 == 0 || year % 100 != 0;
			if(leapYear) {
				days = 29;
			}
			else {
				days = 28;
			}
			break;
		}	
		
		//출력
		System.out.println("해당하는 달의 날짜 수는 " +days+ "일 입니다");
	}
	
}
