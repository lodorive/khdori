package data3;

public class Test06 {
	public static void main(String[] agrs) {
		//369 판정 프로그램
		
		//입력
		int num = 95;
		
		//계산
		//boolean clap = 십의자리에 369 또는 일의자리에 369;
		//boolean tenClap = 십의 자리에 3 또는 6 또는 9;
		//boolean oneClap = 일의 자리에 3 또는 6 또는 9;
		//boolean clap = tenClap || oneClap;
		
		int ten = num / 10;
		int one = num % 10;
		
		boolean tenClap = ten == 3 || ten == 6 || ten == 9;
		boolean oneClap = one == 3 || one == 6 || one == 9;
		boolean clap = tenClap || oneClap;
		
		//출력
		System.out.println(clap);
				
	}
}