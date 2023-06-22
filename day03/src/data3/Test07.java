package data3;

public class Test07 {
	public static void main(String[] args) {
		//윤년 계산기 프로그램
		
		//입력
		int year = 2400;
		
		//계산
		
		//[1] 4의 배수면 윤년 include
		//[2] 100의 배수가 아니어야 한다 exclude
		//[3] 400의 배수면 윤년이다 include
		
		//4의 배수인 해
		boolean is4 = year % 4 == 0; 
		//100의 배수인 해
		//boolean isNot100 = year % 100 != 0;	
		boolean isNot100 = !(year % 100 == 0);
		//!= 대신 괄호 앞에 !를 붙여도 아니라는 의미
		//400의 배수인 해
		boolean is400 = year % 400 == 0;
		
		boolean leapYear = is400 || is4 && isNot100;
		
		//출력
		System.out.println(leapYear);
	}
}
