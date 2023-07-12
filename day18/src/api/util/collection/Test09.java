package api.util.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test09 {
	public static void main(String[] args) {
		//ArrayList 말고 다른 List의 종류
		//-ArrayList는 데이터가 배열 형태로 존재하는 리스트
		// 		-조회 성능이 우수함
		//		-데이터 구조 변경이 느림
		//-LinkedList는 데이터가 연결 형태로 존재하는 리스트
		//	 	- 조회 성능이 다소 떨어짐
		//		- 데이터 구조 변경 성능이 우수
		//-Vector는 과거 자바에서 사용하던 클래스
		//		-조회 성능이 떨어져서 ArrayList로 교체하여 사용
		
		List<String> a = new ArrayList<>();
		List<String> b = new LinkedList<>();
		
		a.add("자바");			b.add("자바");
		a.add("파이썬");		b.add("파이썬");
		a.add("노드");			b.add("노드");
		
		System.out.println(a);
		System.out.println(b);
	}
}
