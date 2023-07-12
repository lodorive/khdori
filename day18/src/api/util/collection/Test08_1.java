package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test08_1 {
	public static void main(String[] args) {
		//네이버 사다리 게임 만들기 풀이
		Scanner sc = new Scanner(System.in);
		
		//[1] 인원 설정
		System.out.println("인원수를 설정하세요");
		int people = sc.nextInt();
		sc.nextLine();
		
		//[2] 이름과 항목 입력
		List<String> names = new ArrayList<>();
		List<String> items = new ArrayList<>();
		
		for(int i=0; i<people; i++) {
		System.out.print("이름 입력 : ");
		names.add(sc.nextLine());
		}
		
		for(int i=0; i<people; i++) {
		System.out.print("항목 입력 : ");
		items.add(sc.nextLine());		
		}
		
		Collections.shuffle(items);
		
		//[3]출력
		System.out.println("<추첨 결과>");
		for(int i=0; i<people; i++) {
		System.out.println(names.get(i)+"->"+items.get(i));
		}
	}
}
