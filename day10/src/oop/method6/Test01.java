package oop.method6;

public class Test01 {
	public static void main(String[] args) {
		
		//생성
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		Student s4 = new Student();
		
		//초기화
		s1.setup(1, 1, "마리오", 50, 60, 50);
		s2.setup(1, 1, "루이지", 60, 90, 50);
		s3.setup(1, 2, "쿠파", 70, 70, 80);
		s4.setup(1, 2, "요시", 80, 85, 35);
		
		//출력
		s1.show();
		s2.show();
		s3.show();
		s4.show();
	}
}
