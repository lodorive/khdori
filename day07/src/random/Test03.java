package random;

import java.util.Random;

public class Test03 {
	public static void main(String[] args) {
		//윷놀이 게임
		//빽도/도/개/걸/윷/모 중 하나가 랜덤
		//랜덤을 이용하여 윷놀이 1턴의 결과 출력
		
		Random r = new Random();
		
		//빽도(0),도(1),개(2),걸(3),윷(4),모(5)
		int game = r.nextInt(6); 
		if(game==0) {
			System.out.println("윷놀이 결과 : 빽도 입니다");
		}
		else if(game==1) {
			System.out.println("윷놀이 결과 : 도 입니다");
		}
		else if(game==2) {
			System.out.println("윷놀이 결과 : 개 입니다");
		}
		else if(game==3) {
				System.out.println("윷놀이 결과 : 걸 입니다");
			}
		else if(game==4) {
			System.out.println("윷놀이 결과 : 윷 입니다");
		}
		else {
			System.out.println("윷놀이 결과 : 모 입니다");
		}
		
		switch(game) {
		case 0: System.out.println("빽도"); break;
		case 1: System.out.println("도"); break;
		case 2: System.out.println("개"); break;
		case 3: System.out.println("걸"); break;
		case 4: System.out.println("윷"); break;
		case 5: System.out.println("모"); break;		
		}
		//실제 윷놀이는 '개'가 가장 많이 나옴 
		//이것을 고려하여 코드를 변경
		
		//경우의 수 : 발생할 수 있는 모든 상황
		//윷이 1개만 있다면 경우의 수는 2가지
		//윷이 2개라면 경우의 수는 4가지
		//윷이 3개라면 경우의 수는 8가지
		//윷이 하나씩 추가될 때마다 2배씩 늘어남
		//윷이 4개라면 경우의 수는 16가지
		
		//빽도(0),도(1,2,3),개(4,5,6,7,8,9),걸(10,11,12,13),윷(14),모(15)
		int game2 = r.nextInt(16); 
		switch(game2) {
		case 0: 
			System.out.println("빽도"); break;
		case 1,2,3:
			System.out.println("도"); break;
		case 4,5,6,7,8,9: 
			System.out.println("개"); break;
		case 10,11,12,13: 
			System.out.println("걸"); break;
		case 14: 
			System.out.println("윷"); break;
		case 15: 
			System.out.println("모"); break;	
		}		
	}
}
