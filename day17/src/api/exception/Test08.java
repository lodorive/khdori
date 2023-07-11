package api.exception;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		//예외를 처리하다보니 발생하는 문제점들을 추가적으로 해결
		//[1] 예외 처리 하기 전 메시지(stack trace)를 보고 싶어요
		//[2] 예외 처리 중 발생하는 경고를 없애고 싶어요
		// -> finally 구문으로 해결 가능
		// -> 반드시 정리해야하는 자원에 대한 코드를 작성
		
		Scanner sc = new Scanner(System.in);
		
		try {				
			System.out.print("금액 : ");
			int money = sc.nextInt();
			if(money < 0){ 
				throw new Exception("금액이 음수일 수 없습니다");
			}
			
			System.out.print("인원 : ");
			int people = sc.nextInt();
			if(people < 0) {
				throw new Exception("인원은 음수일 수 없습니다");
			}
			
			sc.close();
			
			int price = money / people; //1인당 정산금액
			int remain = money % people; //자투리 금액
			
			System.out.println("1인당 내야할 금액은"+price+"원 입니다");
			System.out.println(remain+"원은 저희가 지원해 드려요!");
		}		
			catch(Exception e) { 
				e.printStackTrace(); //예외처리 안한것처럼 스택추적결과를 출력
		}
		//플랜 A/B 중 어느 것이 실행되더라도 마지막에 반드시 실행되는 구문(선택)
		finally {
			sc.close();
		}
	}
}