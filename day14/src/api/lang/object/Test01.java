package api.lang.object;

//java.lang 패키지는 import없이 사용 가능하다(기초 필수 패키지)

public class Test01 {
	public static void main(String[] args) {
		//Object 클래스의 사용법
		//=클래스의 시조(조상)
		//=클래스라면 가져야 되는 기본 스펙에 대한 정의가 있다
		Object a = new Object();
		Object b = new Object();
		
		//자바는 객체를 관리할 때 객체마다 고유한 일련번호를 붙인다(주소 아님)
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
		System.out.println(a.toString());
		System.out.println(b.toString());
	}
}
