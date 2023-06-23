package condition2;

import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		
		//SNS에서 작성한 글이 몇 초 전에 작성되었는지 출력
		//방금 전 / 작성한지 10초가 되지 않은 글
		//?초 전/작성한지 10초 이상 1분이 되지 않은 글
		//?분 전/작성한지 1분 이상 1시간 미만인 글
		//?시간 전/작성한지 1시간 이상 1일 미만인 글
		//?일 전/작성한지 1일 이상인 글
		//사용자에게 '초'를 입력받아서 기준에 따라 게시글 시간 형식을 출력
		
		//현재시간 - 작성시간 = 
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		int second = sc.nextInt();
		
		sc.close();
		
		int time = 50;
		
		//계산
		//String result = "방금전" or "?초전" or "?분전" or "?시간 전" or "?일전" or "오래전';
		String result;
		
		if(time < 10){
			result = "방금 전";
		}
		else if(time < 1 * 60){
			result = time + "초 전";
		}
		else if(time < 1 * 60 * 60){
			result = time / 60 + "분 전";
		}
		else if(time < 1 * 24 * 60 * 60){
			result = time / 60 / 60 + "시간 전";
		}
		else if(time < 1 * 365 * 24 * 60 * 60) {
			result = time / 24 / 60 / 60 + "일 전";
		}
		else {
			result = "오래 전";
		}
		
		//출력
		System.out.println(result);
	}
}