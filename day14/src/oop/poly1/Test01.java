package oop.poly1;

import java.util.Scanner;

public class Test01 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("노트북을 먼저 선택하세요 : ");
		int type = sc.nextInt();
		System.out.print("테스트할 기능을 선택하세요 : ");
		int action = sc.nextInt();
		
		//Laptop laptop = 맥북객체 or 갤럭시북객체;
		Laptop laptop;
		if(type == 1) {
			laptop = new MacBook(); //MacBook ---> Laptop 업캐스팅
		}
		else {
			laptop = new GalaxyBook(); //GalaxyBook ---> Laptop 업캐스팅
		}
		
		//laptop에 들어간 객체의 기능을 실행
		if(action ==1) {
			laptop.power();
		}
		else if(action ==2) {
			laptop.video();
		}
		else {
			laptop.typing();
		}
	}	
}
