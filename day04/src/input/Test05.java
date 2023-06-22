package input;

import java.util.Scanner;
public class Test05 {
	public static void main(String[] args) {
		//분식점 금액 계산기
		//입력
		Scanner sc = new Scanner(System.in);
		
		int menu1Price = 3000;
		int menu2Price = 500;
		int menu3Price = 2000;
		
		System.out.print("떡볶이(3000원)의 개수를 입력하세요 : ");
		int menu1Count = sc.nextInt();
		System.out.print("튀김(500원)의 개수를 입력하세요 : ");
		int menu2Count = sc.nextInt();
		System.out.print("순대(2000원)의 개수를 입력하세요 : ");
		int menu3Count = sc.nextInt();
		
		int rate = 10;
		
		sc.close();
		
		//계산
		int menu1Total = menu1Price * menu1Count;
		int menu2Total = menu2Price * menu2Count;
		int menu3Total = menu3Price * menu3Count;
		
		int total = menu1Total + menu2Total + menu3Total;		
		int disCount = total * rate / 100;		
		int result = total - disCount;
		
		//출력
		System.out.println();
		System.out.println("<결제 정보>");
		System.out.println("결제 금액은 " + total + " 원 입니다");
		System.out.println("할인 금액은 " + disCount + " 원 입니다");
		System.out.println("최종 금액은 " + result + " 원 입니다");
				
	}
}
