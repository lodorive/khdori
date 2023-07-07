package api.lang.string2;

import java.util.Scanner;

public class Test05_1 {
	public static void main(String[] args) {
		//큰달/작은달/2월을 정규표현식으로 구분
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("생년월일 입력(ex: 1900-02-06) : ");
		String age = sc.next();
		
		//^(19[0-9){2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[0-1])&
		String regex = "^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|3[0-1]))|((02)-(0[1-9]|1[0-9]|2[0-9])))$";
		
		if(age.matches(regex)) {
			System.out.println("올바른 생년월일입니다");
		}
		else{
			System.out.println("양식에 맞게 입력하세요");
		}
	}
}
