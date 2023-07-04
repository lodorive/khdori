package oop.keyword7;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		//상수(constant)의 필요성
		//(ex) 가위바위보 출력
		
		//약속 - 가위(0), 바위(1), 보(2)
		
		Random r = new Random();
		
		int choice = r.nextInt(3);
		System.out.println("choice = "+choice);
		
		switch(choice) {
		case 0 :
			System.out.println("가위");
			break;
		case 1 :
			System.out.println("바위");
			break;
		case 2 :
			System.out.println("보");
			break;
		}
		
	}
}
