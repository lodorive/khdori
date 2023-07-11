package api.time;

import java.time.Duration;
import java.time.LocalTime;

public class Test10 {
	public static void main(String[] args) {
		
		String input1 = "09:25";
		String input2 = "13:50";
		
		LocalTime start = LocalTime.parse(input1);
		LocalTime end = LocalTime.parse(input2);
		
		Duration duration = Duration.between(start, end);
		
		System.out.println("총 이용시간 : "+duration.toHoursPart()+"시간 "+duration.toMinutesPart()+"분");
		System.out.println("총 이용요금 : "+duration.toHoursPart()*1000+"원 입니다");

	}
}
