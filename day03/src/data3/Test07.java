package data3;

public class Test07 {
	public static void main(String[] args) {
		//윤년 계산기 프로그램
		
		int year = 2400;
		
		//4의 배수인 해
		int year1 = year % 4; 
		//System.out.println(year1);		
		
		//100의 배수인 해
		int year2 = year % 100;
		//System.out.println(year2);		
		
		//400의 배수인 해
		int year3 = year % 400;
		//System.out.println(year3);		
		
		boolean condition1 = year1 == 0;
		boolean condition2 = year2 != 0;
		boolean condition3 = year3 == 0;
				
		boolean leapyear = condition1 && condition2 || condition3;
		
		System.out.println(leapyear);
	}
}
