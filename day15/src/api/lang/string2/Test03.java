package api.lang.string2;

public class Test03 {
	public static void main(String[] args) {
		//사용자에게 휴대전화번호를 입력받아 유효한지 아닌지 판정하여 출력
		//정규 표현식(REGular EXpresstion) 
		
		String number = "01012345678";
		
		//^(010|011|016|017|018|019)-xxxx-xxxx$
		String regex = "^01[016-9][1-9][0-9]{2,3}[0-9]{4}$";
		//boolean isValid = Pattern.matches(regex, number);
		boolean isValid = number.matches(regex);
		
		if(isValid) {
		System.out.println("유효한 전화번호입니다");
		}
		else {
			System.out.println("잘못된 전화번호입니다");
		}
	}
}
