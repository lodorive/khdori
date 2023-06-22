package condition;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		//여행사 할인 프로모션2
		//여름(6,7,8) 여행시 비용에서 25% 할인
		//여름이 아닌 게절에는 할인 X
		//국내 어디든 1인 1박에 10만원
		
		//입력
		Scanner sc = new Scanner(System.in);
		
		int price = 100000;
		System.out.print("총 인원을 입력하세요 : ");
		int people = sc.nextInt();
		System.out.print("떠나는 일 수를 입력하세요 : ");
		int days = sc.nextInt();
		System.out.print("떠나는 계절을 월로 입력하세요(ex: 4) : ");
		int month = sc.nextInt();
		
		sc.close();
		
		//계산
		
		int total = people * price * days;
		boolean summer = month == 6 || month == 7 || month == 8;
		//int seasonEvent = month/3;
		
		//출력
		//if(summer == true) {
		//if(summer) {
			//System.out.println("할인가 " + total * 75 / 100 + "입니다");
		//}
		//else {
			//System.out.println("정상가 " + total + "원입니다");
		//}
		
		int disCount;
		//if(seasonEvent == 2){
		if(summer){
				disCount = total * 25 / 100;
		}
		else {
				disCount = 0;
		}		
		
		int result = total - disCount;
		
		System.out.println("정상가 " + total + " 입니다");
		System.out.println("할인금액 " + disCount + " 입니다");
		System.out.println("판매가 " + result + " 입니다");
	}
}
