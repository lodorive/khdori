package api.lang.test;

public class Test01 {
	public static void main(String[] args) {
		//StringBuffer 클래스를 문서만 보고 써보기
		
		//객체 생성
		StringBuffer a = new StringBuffer(10);
		StringBuffer b = new StringBuffer("Hello");
		
		//메소드 활용
		a.append("KH정보교육원");
		
		System.out.println("a의 요약본 : "+a.toString());
		System.out.println("b의 요약본 : "+b.toString());
		
		System.out.println("a의 용량 : "+a.capacity());
		System.out.println("b의 용량 : "+b.capacity());
		
		System.out.println("a의 글자수 : "+a.length());
		System.out.println("b의 글자수 : "+b.length());
		
		System.out.println("b의 글자 뒤집기 : "+b.reverse());
	}
}
