package condition;

import java.util.Scanner;

public class Test05_2 {
		public static void main(String[] args) {
			//과속 단속 카메라
			
			//입력
			Scanner sc = new Scanner(System.in);
			
			System.out.print("속도(km) : ");
			int speed = sc.nextInt();
			
			sc.close();
			
			int limit = 50;
			
			//계산
			int overSpeed = speed - limit;
			boolean over = speed > limit;
			
			int fine; //0 또는 어쩌구 저쩌구
			if(over){
				fine = 30000 + overSpeed / 10 * 10000;
			}
			else {
				fine = 0;
			}
			//출력

				System.out.println("벌금 : " + fine + " 원");			
		}
}
