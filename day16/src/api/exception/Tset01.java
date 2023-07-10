package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tset01 {
	public static void main(String[] args) {
		//예외 처리 구문
		//try {
		//	플랜 A코드
		//}
		//catch{
		//	플랜 B코드
		//}
		
		try {	
			Scanner sc = new Scanner(System.in);
			
			System.out.print("금액 : ");
			int money = sc.nextInt();
			
			System.out.print("인원 : ");
			int people = sc.nextInt();
			
			sc.close();
			
			int price = money / people; //1인당 정산금액
			int remain = money % people; //자투리 금액
			
			System.out.println("1인당 내야할 금액은"+price+"원 입니다");
			System.out.println(remain+"원은 저희가 지원해 드려요!");
		}
		catch(ArithmeticException e) {
			//플랜B-1. 인원수를 0을 입력했을 때
			System.err.println("인원수는 0일 수 없습니다");
		}
		catch(InputMismatchException e){
			//플랜B-2. 입력을 잘못했을때
			System.err.println("입력을 숫자로 해야 합니다");
		}
	}
}
