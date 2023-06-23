package condition2;

import java.util.Scanner;

public class Test04_1 {
	public static void main(String[] args) {
		
		//여행사 프로모션3
		//1인당 1박 10만원
		//계절별로 할인
		//봄 20% 여름 10% 가을 30% 겨울 5%
		
		//입력
		
		int price = 100000;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원을 입력하세요 : ");
		int people = sc.nextInt();
		
		System.out.print("떠나는 일 수를 입력하세요 : ");
		int days = sc.nextInt();
		
		System.out.print("떠나는 월을 입력하세요 : ");
		int month = sc.nextInt();
		
		sc.close();
		
		//계산
		int total = people * price * days;
		
		//int rate = 20 or 10 or 30 or 5;
		int rate;
		
		if(month == 3 || month == 4 || month == 5){//봄이면
			rate = 20;
		}
		else if(month == 6 || month == 7 || month == 8){//여름이면
			rate = 10;
		}
		else if(month == 9 || month == 10 || month == 11){//가을이면
			rate = 30;
		}
		else {//겨울이면
			rate = 5;
		}
		
		int discount = total * rate / 100; //할인금액
		int result = total - discount; //최종경비
		
		//출력
		System.out.println();
		System.out.println("예상 경비는 " + total + " 입니다");
		System.out.println("할인율은 " + rate + "% 입니다");
		System.out.println("할인 금액은 " + discount + " 입니다");
		System.out.println("최종 경비는 " + result + " 입니다");
			}
				}
