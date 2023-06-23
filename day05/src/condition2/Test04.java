package condition2;

import java.util.Scanner;

public class Test04 {
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
		int season = month/3;
		
		int discount;
		
		if(season == 1){//봄이면
			discount = total * 20 / 100;
		}
		else if(season == 2){//여름이면
			discount = total * 10 / 100; 
		}
		else if(season == 3){//가을이면
			discount = total * 30 / 100; 
		}
		else {//겨울이면
			discount = total * 5 / 100;
		}
		
		int pay = total - discount;
		
		//출력
		System.out.println("예상 경비는" + total + "입니다");
		System.out.println("할인 금액은" + discount + "입니다");
		System.out.println("최종 경비는" + pay + "입니다");
			}
				}

