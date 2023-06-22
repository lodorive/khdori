package condition;

public class Test01 {
	public static void main(String[] args) {
		//조건(Condition)
		
		int number = 7;		
		//if(number가 홀수라면)
		
		if(number % 2 != 0){
			System.out.println("홀수");
		}
		
		//if(number가 짝수라면)		
		//if(number % 2 == 0)
		else{
			System.out.println("짝수");
		}
		
	}
}
