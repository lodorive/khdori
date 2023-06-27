package random;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		//무작위 로또 번호 1개
		//무작위 두 자리 정수 1개
		//무작위 OTP 번호 1개(OTP번호는 총 6자리로 구성)
		//무작위로 앞/뒤 출력
		//무작위로 가위바위보 출력
		
		Random r = new Random();
		
		int lotto = r.nextInt(45) + 1;
		System.out.println("로또번호 = "+lotto);
		
		//10부터 99까지 중 하나(99-10+1)
		int number = r.nextInt(90) + 10;
		System.out.println("두 자리 정수 = "+number);
		
		//000000부터 999999 사이(999999-0+1)
		int otp = r.nextInt(1000000);
		System.out.println("otp번호 = "+otp);		
		
		//Format f = new DecimalFormat("000000");
		//System.out.println(f.format(otp)); 
		//맨 앞자리 0 나오게 하는 방법
		
		//(약속) 앞=0, 뒤=1
		int coin = r.nextInt(2); //0부터 1까지 
		if(coin==0) {
			System.out.println("동전 = 앞");
		}
		else {
			System.out.println("동전 = 뒤");
		}
		
		//가위=0, 바위=1, 보=2
		int rsp = r.nextInt(3); //0부터 2까지
		if(rsp==0) {
			System.out.println("가위");
		}
		else if(rsp==1) {
			System.out.println("바위");
		}
		else {
			System.out.println("보");
		}
	}
}
