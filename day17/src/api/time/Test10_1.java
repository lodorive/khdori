package api.time;

import java.time.Duration;
import java.time.LocalTime;

public class Test10_1 {
	public static void main(String[] args) {
		//문제 풀이
		
		//입력
		String begin = "14:30";
		String end = "19:15";
		
		//계산
		LocalTime t1 = LocalTime.parse(begin);
		LocalTime t2 = LocalTime.parse(end);
		
		Duration duration = Duration.between(t1, t2);
		long time = duration.getSeconds(); //이용시간(초)
		
		time /= 60;
		
		long hour = time / 60;
		long minute = time % 60;
		
		//요금계산
		int pricePerHour = 1000;
		float pricePerMinute = pricePerHour / 60f;
		float totalPrice = pricePerMinute * time;
		
		//출력
		System.out.println("총 이용시간 : "+hour+"시간 "+minute+"분");
		
		//같은 방식(선택)
		System.out.println("총 이용요금 : "+totalPrice+"원 입니다");
		System.out.println("총 이용요금 : "+(int)totalPrice+"원 입니다");
		System.out.println("총 이용요금 : "+Math.floor(totalPrice)+"원 입니다");
		System.out.println("총 이용요금 : "+Math.round(totalPrice)+"원 입니다");
		System.out.println("총 이용요금 : "+Math.ceil(totalPrice)+"원 입니다");

	}
}
