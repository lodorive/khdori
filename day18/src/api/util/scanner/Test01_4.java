package api.util.scanner;

import java.util.Scanner;

public class Test01_4 {
	public static void main(String[] args) {
		//Scanner 클래스
		//= 문자열 입력 및 분석 클래스
		//= 키보드 입력은 기능 중 일부분일 뿐
		//= 파일 뿐 아니라 홈페이지도 읽어올 수 있다(웹 크롤링)
		
		String sample = "떳다떳다 비행기|\n날아라 날아라\n떳다떳다 비행기\n우리 비행기";
		//System.out.println(sample);
		
		//[1] 단어별로 읽기	.next()			띄어쓰기나 개행 등 공백이 기준
		//							.hasNext()		읽을 수 있는 단어가 있는지 판정
		//[2] 줄별로 읽기		.nextLine()		개행 문자만 기준
		//							.hatNextLine() 읽을 수 있는 줄이 있는지 판정 
		
		//[Q] .next()와 .nextLine()을 섞어쓰면 어떻게 될까?
		//[A] 섞어쓰면 문제가 발생한다(.next() 다음에 .nextLine()을 쓰면 발생)
		
		Scanner sc = new Scanner(sample);
		
		System.out.println(sc.next());
		System.out.println(sc.next());
		System.out.println(sc.nextLine()); //버리는 명령으로 사용
		System.out.println(sc.nextLine());
		
		sc.close();
	}
}
