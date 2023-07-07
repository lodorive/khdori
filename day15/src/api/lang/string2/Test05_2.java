package api.lang.string2;

//import java.util.Scanner;

public class Test05_2 {
	public static void main(String[] args) {
		//윤년을 알아내기 위한 방법
		//[1] 문자열에서 연도를 잘라내는 방법 (String 클래스)
		//[2] 문자열을 정수로 변환하는 방법 (Integer 클래스)
		
		//Scanner sc = new Scanner(System.in);
		
		//System.out.print("생년월일 입력(ex: 1900-02-06) : ");
		//String age = sc.next();
		String age = "2000-02-29";
		
		//[1] .substring(시작위치,종료위치)
		String yearStr = age.substring(0,4);
		System.out.println("yearStr = "+yearStr);
		
		int year = Integer.parseInt(yearStr);
		System.out.println("year = "+year);
		
		boolean leapYear = year % 400 == 0 || (year % 4 == 0 && year % 100 ==0);
		
		String regex;
		
		if(leapYear) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((02)-(0[1-9]|1[0-9]|2[0-9])))$";
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((02)-(0[1-9]|1[0-9]|2[0-8])))$";
		}
		
		if(age.matches(regex)) {
			System.out.println("올바른 날짜");
		}
		else {
			System.out.println("잘못된 날짜");
		}
	}
}
