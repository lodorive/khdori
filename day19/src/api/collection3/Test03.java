package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//투표 프로그램
		
		Map<String, Integer> voting = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			
		System.out.print("이름 입력 : ");
		String name = sc.next();
		
		if(name.equals("종료")) break;
		
			if(voting.containsKey(name)){
				voting.put(name, voting.get(name)+1);
				System.out.println("["+name+"] 현재 "+voting.get(name)+"표 흭득!");
			}
			else {
				voting.put(name, 1);
				System.out.println("["+name+"] 현재 "+voting.get(name)+"표 흭득!");
			}
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");
		System.out.println(voting);
	}
}
