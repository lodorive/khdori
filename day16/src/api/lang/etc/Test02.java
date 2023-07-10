package api.lang.etc;

public class Test02 {
	public static void main(String[] args) {
		//Math 클래스
		//= 객체를 의도적으로 생성 불가 처리하고 전부다 static 키워드를 사용
		//= 객체 없이 아무데서나 편하게 호출이 가능하도록 구성
		
		//필드
		System.out.println(Math.PI); //원주율
		System.out.println(Math.E); //자연지수(Exp)
		
		//메소드
		System.out.println(Math.abs(10-20)); //절대값(absolute)
		System.out.println(Math.abs(20-10));
		
		System.out.println(Math.round(1.4)); //반올림
		System.out.println(Math.round(1.5));
		
		System.out.println(Math.floor(1.4)); //버림
		System.out.println(Math.floor(1.5));
		
		System.out.println(Math.ceil(1.4)); //올림
		System.out.println(Math.ceil(1.5));
		
		System.out.println(Math.pow(2, 10)); //2의 10제곱
		
		System.out.println(Math.sqrt(9)); //루트 9
		
		//[Q] 피타고라스 정리에 따르면 직각삼각형에서 밑변² + 높이² = 빗변² 입니다
		//밑변이 3이고 높이가 4일 때 빗변의 길이를 구하세요
		
		double len = Math.sqrt(Math.pow(3, 2) + Math.pow(4, 2));
		System.out.println(len);
		
		double len2 = Math.hypot(3, 4);
		System.out.println(len2);
	}
}
