package api.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test05 {
	public static void main(String[] args) {
		
		Calendar c = Calendar.getInstance();
		Random r = new Random();
		
		//계산
		int value = r.nextInt(365) +1;
		c.set(2023, 0, value);
		
		//출력
		Date d = c.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(fmt.format(d));
	}
}
