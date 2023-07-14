package api.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Test02 {
	public static void main(String[] args) {
		//로그인 프로그램
		
		//저장소 생성
		Map<String, String> rogin = new TreeMap<>();
		
		//데이터를 미리 추가
		rogin.put("admin", "admin1234");
		rogin.put("teacher", "teacher1234");
		rogin.put("student", "student1234");
		rogin.put("manager", "manager1234");
		
		Scanner sc = new Scanner(System.in);
		
		//아이디 비밀번호를 입력
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 입력 : ");
		String pw = sc.nextLine();
		
		sc.close();
		
		//if(rogin.containsKey(id) && rogin.containsValue(pw)) {//잘못된 표현
		if(rogin.containsKey(id) && pw.equals(rogin.get(id))) {//올바른 표현
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
		
	}
}
