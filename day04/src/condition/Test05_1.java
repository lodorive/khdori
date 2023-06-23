package condition;

public class Test05_1 {
		public static void main(String[] args) {
			//과속 단속 카메라
			
			//입력
			int speed = 60;
			int limit = 50;
			
			//계산
			boolean over = speed > limit;
			
			
			//출력
			if(over ==  true){
				int overSpeed = speed - limit;
				int fine = 30000 + overSpeed / 10 * 10000;
				System.out.println("벌금 : " + fine + " 원");
			}
			else {
				System.out.println("벌금 : 0원");
				
			}
		}
}
