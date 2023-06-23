package condition3;

public class Test01 {
	public static void main(String[] args) {
		//switch~case 구문
		//- if 구문은 "순차적"으로 실행되는 특징이 있다
		//- 이게 문제가 되는 상황이 있다
		
		//입력 - 월 정보
		int month = 9;
		
		if(month == 3 || month == 4 || month == 5) {
			System.out.println("봄");
		}
		else if(month == 6 || month == 7 || month == 8) {
			System.out.println("여름");
		}
		else if(month == 9 || month == 10 || month == 11) {
			System.out.println("가을");
	}
		else {
			System.out.println("겨울");
			}
		}
}
