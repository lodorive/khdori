package condition3;

public class Test02 {
	public static void main(String[] args) {
		//switch~case 구문
		
		//입력 - 월 정보
		int month = 7;
		
		switch(month) {//month에 있는 값을 토대로 실행 지점을 찾겠다
		case 12, 1, 2:
			System.out.println("겨울");
			break; //그만하고 나가라
		case 3, 4, 5:
			System.out.println("봄");
			break;
		case 6, 7, 8:
			System.out.println("여름");
			break;
		default: //else
			System.out.println("가을");
		}

		}
}
