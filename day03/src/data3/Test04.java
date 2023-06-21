package data3;

public class Test04 {
	public static void main(String[] args) {
		//청소년 판정 프로그램
		//청소년은 14살 이상 29세 이하
		
		//입력
		int age = 5;
		
		//계산
		boolean teen = 14 <= age && age <= 19;
		boolean free = 8 > age || age >= 65;
		
		//논리연산 - 논리끼리 계산하기 위한 기호
		//&&(and) 왼쪽과 오른쪽이 모두 참일 경우 참(참참참)
		//||(or) 왼쪽과 오른쪽이 모두 거짓인 경우 거짓, 둘 중 하나라도 참이면 참
		
		//출력
		System.out.println(teen);
		System.out.println(free);
	}
}
