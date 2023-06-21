package data3;

public class Test05 {
	public static void main(String[] args) {
		
		//건강검진은 30세 이상인 사람들을 대상으로 2년에 한 번씩
		//올해가 짝수 해라면, 짝수년도 출생자가 대상
		//올해가 홀수 해라면, 홀수년도 출생자가 대상
		//어떤 사람의 출생년도를 입력값으로 두고 
		//이 사람이 올해 건강검진 대상자인지 아닌지 출력
		
		//30세 이상 && (짝수해이면서 짝수년생 || 홀수해이면서 홀수년생)
		
		//입력
		int birth = 1985; //1985010의 경우 나누기 10000
		int year = 2023;
		
		//계산
		int age = year - birth + 1;
		boolean condition1 = age >= 30;
		boolean condition2a = year % 2 == 0;
		boolean condition2b = birth % 2 == 0;
		boolean condition2 = condition2a && condition2b;
		//boolean condition2 = year % 2 == 0 && birth % 2 ==0;
		
		boolean condition3a = year % 2 != 0;
		boolean condition3b = birth % 2 != 0;
		boolean condition3 = condition3a && condition3b;
		//boolean condition3 = year % 2 != 0 && birth % 2 != 0;
		
		boolean condition = condition1 && (condition2 || condition3);
		
		//출력
		System.out.println(condition);
	}
}
