package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test03_1 {
	public static void main(String[] args) {
		//투표 프로그램 문제 풀이
		
		//투표함 만들기
		Map<String, Integer> vote = new HashMap<>();
		
		//샘플 데이터 추가
		vote.put("임영웅", 5);
		vote.put("아이유", 2);
		vote.put("박보영", 3);
		vote.put("유재석", 1);
		
		Scanner sc = new Scanner(System.in);
		
		//사용자 투표한 내용을 투표함에 반영
		while(true) {
		System.out.println("당신의 아이돌에게 투표하세요!");
		String name = sc.nextLine();
		
		if(name.equals("종료")) {
				break;}
		
		name = name.replace(" ", "").toLowerCase(); //공백 제거
		
		int count;  
		if(vote.containsKey(name)) {//이름이 있으면
			count = vote.get(name); //이름에 해당하는 득표수를 추출
		}
		else {//이름이 없으면
			count = 0; //null 대신 0을 출력
			vote.put(name, count);
		}
		count++;
		vote.put(name, count);

		//출력
		//System.out.println(vote);
		System.out.println("["+name+"}"+"현재 득표수"+vote.get(name));
		}
		sc.close();
		System.out.println(vote);
	}
}
