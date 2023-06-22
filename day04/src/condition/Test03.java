package condition;

import java.util.Scanner;

public class Test03 {
	public static void main(String[] args) {
		//65세 이상 어르신들만 30% 할인된 가격에 판매
		//국밥 한 그릇에 7500원
		//출생년도 4자리와 그릇 수를 입력 받아 결제 금액을 계산
		
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("출생년도 4자리를 입력하세요 : ");
		int birth = sc.nextInt();
		System.out.print("그릇 수를 입력하세요 : ");
		int count = sc.nextInt();
		
		sc.close();
		
		int year = 2023;
		int price = 7500;
		
		
		//계산
		int age = year - birth + 1; // 나이 계산
		
		int total = price * count; // 금액 계산
		
		int disCount;
		if(age >= 65){
				disCount = total * 30 / 100;
		}
		else{
				disCount = 0;
		}
		
		int result = total - disCount;
		
		//출력
			System.out.println("나이는 " + age + " 세 입니다");
			System.out.println("금액은 " + result + " 입니다");
	}
}
