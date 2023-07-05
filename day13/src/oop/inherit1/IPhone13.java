package oop.inherit1;

public class IPhone13 {
	//필드
	private String number; //전화번호
	private String color; //색상
	private int price; //가격
	
	//메소드 - 기능
	//setter/getter 생략
	public void call() {
		System.out.println("전화걸기");
	}
	public void camera() {
		System.out.println("사진찍기");
	}
	public void siri() {
		System.out.println("시리야");
	}
}
