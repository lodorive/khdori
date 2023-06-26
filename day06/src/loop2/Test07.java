package loop2;

public class Test07 {
	public static void main(String[] args) {
		
		//30일 동안 매일 하루에 푸시업 20개
		
		int total = 0;
		
		for(int day = 1; day <= 30; day++){
		System.out.println(day+"일차 : 20개");
			total +=20;
		}
		System.out.println("합계 = "+total +"개");
		
		
		//30일 동안 첫날 10개 이후 3개씩 늘려가며 푸시업			
		
		int pushUp = 10; //추천
		int total2 = 0;
		
		for(int day2 = 1; day2 <= 30; day2++) {
			//int pushUp = day2 * 3 + 7; //(복잡)
			//int pushUp = 10 + (day-1) * 3; //비추천(복잡)
			System.out.println(day2+"일차 : "+pushUp +"개"); 
			total2 += pushUp; //total을 puchup 개수만큼 증가처리
			pushUp += 3; //3개씩 증가  
		}
		System.out.println("합계 ="+total2+ "개");
	}
}
