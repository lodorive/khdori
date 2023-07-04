package oop.modifier4;

import oop.modifier3.Student;

public class Test01 {
	public static void main(String[] args) {
		//Student의 객체(인스턴스)
		//자바의 기본 접근제한은 패키지 범위
		//패키지에 없는 것은 모른다고 간주
		//import를 통해 알려줘서 해결 가능 
		//단, import는 public만 가능 
		Student a = new Student();
		
		a.setName("피카츄");
		a.setScore(100);		
	}
}
