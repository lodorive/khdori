package api.lang.string2;

public class Test04 {
	public static void main(String[] args) {
		//아이디 검사 문제 
		
		String id = "sjkfksks12456";
		
		String regex = "^[a-z][a-z0-9\\-_]{4,19}$";
		
		if(id.matches(regex)) {
			System.out.println("올바른 아이디 형식입니다");
		}
		else {
			System.out.println("5~20자의 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다");
		}
	}
}
