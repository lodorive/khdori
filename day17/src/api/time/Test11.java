package api.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test11 {
	public static void main(String[] args) {
		//LocalDateTime 클래스
		//날짜와 시간을 모두 보유한 클래스(=Date, Calendar)
		
		//생성 - of(), parse(), now()
		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.of(2023, 7, 11, 17, 50, 30);
		LocalDateTime t3 = LocalDateTime.parse("2023-07-11T17:50:30");
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		System.out.println(t1.isAfter(t3));
		
		LocalDateTime t4 = t1.plusHours(5L); //5시간뒤
		System.out.println(t4);
		
		//간격 구하기
		Duration duration = Duration.between(t1, t4);
		System.out.println(duration.getSeconds()); 
		
		LocalDate date = t4.toLocalDate();
		LocalTime time = t4.toLocalTime();
		System.out.println(date);
		System.out.println(time);
	}
}
