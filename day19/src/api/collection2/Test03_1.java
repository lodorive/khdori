package api.collection2;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Test03_1 {
	public static void main(String[] args) {
		//좋아요 이력 관리 프로그램
		//= 비슷한 것들 : 팔로우, 좋아요, 추천, 싫어요, 즐겨찾기, 구독, 알람, ...
		//= 토글(toggle) : 두 가지 상태를 왔다갔다 하는 것 (ex: 스위치)
		
		Set<Integer> memory = new TreeSet<>();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		System.out.print("글번호 : ");
		int no = sc.nextInt();
		
		if(no <= 0) break;
				
		//메모리(저장소)에 번호가 있다 = 좋아요를 한 글 번호
		if(memory.contains(no)) {
			memory.remove(no); //좋아요 취소
			System.out.println(no+"번 글♡");
		}
		else {//메모리(저장소)에 번호가 없다 = 좋아요를 한 적이 없는 글 번호
			memory.add(no); //좋아요 처리
			//System.out.println(no+"번 글에 좋아요를 설정했습니다");
			System.out.println(no+"번 글♥");
			}
		}
		sc.close();
		
		System.out.println("좋아요 누른 글 번호들");
		System.out.println(memory);
	}
}
