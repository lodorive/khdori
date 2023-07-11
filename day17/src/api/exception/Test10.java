package api.exception;

public class Test10 {
	public static void main(String[] args) {
		//Calculator의 메소드를 호출하는 상황
		//- 예외 처리 구문은 바깥에 한 번만 만드는 것이 이상적이다
		//throws(예외 전가) 처리된 메소드는 플랜 B를 준비하고 불러야 한다
		// [1] 나도 예외를 처리하지 않겠다(플랜B 같은건 없다)
		// [2] 예외를 처리하겠다(try ~ catch 구문 사용)
		
		try {
			int result = Calculator.div(10, 0);
			System.out.println("result = "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
