package api.lang.string;

public class Test05 {
	public static void main(String[] args) {
		//문자열 검사 
		//= 전부 또는 일부분에 대한 검사를 위한 명령
		
		String nickname = "운영자입니다운영자";
		
		//운영자가 포함되어 있습니까?
		System.out.println(nickname.contains("운영자")); 
		
		//운영자가 어디 있습니까?
		//= 문자열은 배열처럼 0부터 시작하도록 구성되어 있다
		System.out.println(nickname.indexOf("운영자")); //좌측부터 탐색
		System.out.println(nickname.lastIndexOf("운영자")); //우측부터 탐색
		
		System.out.println(nickname.indexOf("없는글자")); //없으면 -1
		
		//시작과 종료 글자 검사
		String url = "https://www.naver.com";
		
		//http가 있는 위치가 0입니까?
		System.out.println(url.indexOf("http") ==0);
		//http로 시작합니까?
		System.out.println(url.startsWith("http"));
		//.com으로 끝납니까?
		System.out.println(url.lastIndexOf(".com")==url.length()-".com".length());
		System.out.println(url.endsWith(".com"));
		
		//글자의 원하는 위치 추출
		String text = "안녕하세요";
		System.out.println(text.charAt(0)); //0번의 위치 글자 추출
		
		char ch = text.charAt(0);
		boolean isAlphabet = (ch>= 'A' && ch<= 'Z') || (ch >='a' && ch<='z');
		System.out.println("isAlphabet = "+isAlphabet);
		
		//boolean isKorean = ch>= 44032 && ch <=55203;
		boolean isKorean = ch>= '가' && ch <='힣';
		System.out.println("isKorean = "+isKorean);
	}
}
