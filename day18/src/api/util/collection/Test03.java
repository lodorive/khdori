package api.util.collection;

import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//기억력 테스트 게임
		
		//저장소 생성
		ArrayList<String> history = new ArrayList<>();
		
		//입력도구 생성
		Scanner sc = new Scanner(System.in);

		//사용자 입력
		while(true) {
		System.out.print("나라 이름 입력 : ");
		String name = sc.next();
		
		if(history.contains(name)) {
			break;
		}
		else {
			history.add(name);
			}
		}
		sc.close();
		
		System.out.println("게임 오버!");
		System.out.println("총 "+history.size()+"개의 나라를 입력했습니다");
	}
}
	
