package api.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		//네이버 사다리 게임 만들기
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> name = new ArrayList<>();
		ArrayList<String> type= new ArrayList<>();
		
		System.out.print("인원수 입력 : ");		
		int num = sc.nextInt();
		
		for(int i=0; i<=num; i++) {
			System.out.print("이름 입력 : ");
			name.add(sc.next());
		}
		
		for(int i=0; i<=num; i++) {
		System.out.print("항목 입력 : ");
		type.add(sc.next());	
		}
		
		Collections.shuffle(type);
		
		for(int i =0; i<num; i++) {			
		System.out.println("이름 : "+name.get(i)+" 항목 : "+type.get(i));		
		}
	}
}
