package condition;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		
		//과속단속 카메라 프로그램
		//50km를 초과하는 속도로 달리는 자동차 단속
		//기본 벌금은 30000원
		//벌금은 제한속도보다 10km 이상빨라질 때마다 10000원씩 증가
		
		//입력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("자동차의 속도를 입력하세요(km) : ");
		int car = sc.nextInt();
		
		sc.close();
		
		int speed = 50;
		int fine = 30000;
		
		//계산
		boolean speedcar = car > 50; 
		int penalty = (car - speed) / 10 * 10000;
		
		int total;
		if(speedcar){
					total = fine + penalty;
		}
		else {
					total = 0;
		}
		
		//출력
		System.out.println("예상 벌금은 " +  total + " 원 입니다");
	}
}