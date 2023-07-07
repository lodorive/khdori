package api.lang.string2;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		//생년월일 입력받아 검사 후 출력
		//연도는 1900년부터 2099년까지
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생년월일 입력(ex: 1900-02-06) : ");
		String age = sc.next();
		
		//^(19[0-9){2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])&
		String regex = "^(19[0-9][0-9]|20[0-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
		
		if(age.matches(regex)) {
			System.out.println("올바른 생년월일입니다");
		}
		else{
			System.out.println("양식에 맞게 입력하세요");
		}
	}
}
