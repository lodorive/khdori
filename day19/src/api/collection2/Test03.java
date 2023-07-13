package api.collection2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test03 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> like = new HashSet<>();
		
		while(true) {
			
		System.out.print("숫자 입력 : ");
		int number = sc.nextInt();		
		
		if(number>0) {
		
				if(like.contains(number)) {
					System.out.println(number+"번 글에 좋아요를 취소했습니다");
					like.remove(number);
				}
				
				else{
					System.out.println(number+"번 글에 좋아요를 눌렀습니다");
					like.add(number);
				}			
		}
		else break;				
	}
		sc.close();
		System.out.println("좋아요 설정한 글 번호"+like);
	}
}
