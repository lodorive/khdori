package loop2;

public class Test08 {
	public static void main(String[] args) {
		// 현명한 노인 문제
		// 30일 동안 노인이 받는 금액
		int money = 1; //1원으로 시작
		int total = 0; //합계는 최초 0
		
		for(int day = 1; day <=30; day++) {//30일동안
			System.out.println(day+"일차 받는 돈 : " +money+"원");
			total += money; //total을 money 증가 금액만큼 더하기(누적)
			money *= 2; //두배씩
		}
		System.out.println("노인이 받는 총 금액 : "+total+"원");
		System.out.println();
		
		
		// 40일 동안 노인이 받는 금액
		long money2 = 1L;
		long total2 = 0L;
		
		for(int day2 = 1; day2 <=40; day2++) {//40일동안
			System.out.println(day2+"일차 받는 돈 : " +money2+"원");
			total2 += money2;
			money2 *= 2;
		}
		System.out.println("노인이 받는 총 금액 : "+total2+"원");
			}
		}
