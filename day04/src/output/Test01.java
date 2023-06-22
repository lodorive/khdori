package output;

public class Test01 {
	public static void main(String[] args) {
		//출력 - CPU를 기준으로 데이터가 외부로 나가는 것
		//표준 출력 
		//- 표준 출력장치로 데이터가 나가는 것
		//- System.out 을 사용
		
		//[1] print()는 글자를 외부로 단순 출력
		System.out.print("hello");
		System.out.print("world");
		
		//줄바꿈
		System.out.print("\n");
		System.out.println();
		
		//[2] println()은 글자를 출력 후 줄바꿈 처리
		System.out.println("hello");
		System.out.println("world");
		
		//[3] C언어 방식
		System.out.printf("hello");
		System.out.printf("world");
		
		System.out.println();
		
		int a = 10;
		int b = 20;
		int c = a + b;
		System.out.printf("%d + %d = %d\n", 10, 20, 30);
		System.out.println(a + " + " + b + " = " + c);
	
		
	}
}









