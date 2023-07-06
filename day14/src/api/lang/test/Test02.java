package api.lang.test;

import java.util.Properties;

public class Test02 {
	public static void main(String[] args) {
		//객체 생성
		Properties prop = new Properties();
		
		//기능 사용
		prop.setProperty("hello", "world");
		prop.setProperty("good", "bye");
		
		//객체의 요약정보
		System.out.println(prop.toString());
		
		//key = hello인 
		//아래 두 방법 중 아무거나 사용하면 됨
		String value = prop.getProperty("hello");
		System.out.println(value);
		System.out.println(prop.getProperty("hello"));
	}
}
