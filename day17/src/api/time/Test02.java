package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test02 {
	public static void main(String[] args) {
		
		//시간 객체
		Date a = new Date();
		
		//형식 객체
		SimpleDateFormat fmt1 = new SimpleDateFormat("y년 M월 d일");
		SimpleDateFormat fmt2 = new SimpleDateFormat("a h시 m분");
		SimpleDateFormat fmt3 = new SimpleDateFormat("H:mm:ss");
		SimpleDateFormat fmt4 = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss");

		//출력
		System.out.println(fmt1.format(a));
		System.out.println(fmt2.format(a));
		System.out.println(fmt3.format(a));
		System.out.println(fmt4.format(a));
	}
}
