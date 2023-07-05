package oop.inherit1;

public class IPhone14 {
	//필드
	private String number; //번호
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
	public void facetime() {
		System.out.println("영상통화");
	}
}
