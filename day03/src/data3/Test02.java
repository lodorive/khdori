package data3;

import java.util.Calendar;

public class Test02 {
	public static void main(String[] args) {
		//편의점 한국 나이 20세 이상에게 술, 담배 판매
		//2003년생에게 팔아도 되는지 판정하여 출력
		Calendar cal = Calendar.getInstance();
        System.out.println("The Current Year is:" + cal.get(Calendar.YEAR));
		
		//입력
		int birth = 2003;
		int year = cal.get(Calendar.YEAR);
		
		//계산
		int age = year- birth + 1;		
		boolean adult = age >= 20;
		
		//출력
		System.out.println(adult);
	}
}