package api.lang.string2;

public class Member {
	//회원가입 프로그램
	//회원아이디(memberId) - 8~20자 알파벳+숫자 구성
	//회원비밀번호(memberPw) - 8~15자 알파벳+숫자+특수문자 반드시 포함하여 구성
	//회원이름(memberName) - 한국인 이름
	//회원등급(memberLevel) - 관리자 / 우수회원 / 일반회원 중 하나로 설정, 기본값은 일반회원
	//회원포인트(memberPoint) - 최초 100점을 부여, 0 이상만 가능
	
	
	//Scanner를 통해서 가입에 필요한 정보를 입력받아 객체를 생성하고 출력
	//단, 비밀번호는 첫 글자를 제외한 나머지 마스킹 처리하여 출력
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private	String memberLevel;
	private int memberPoint;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		String regex = "^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{8,20}$";
		
		if(memberId.matches(regex)) {
			this.memberId = memberId;
			}
		else {
			return;
		}
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		String regex = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,15}$";
		
		if(memberPw.matches(regex)) {
			this.memberPw = memberPw;
			}
		else {
			return;
		}
		
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		
		int count = 0;
		
		for(int i = 0; i<memberName.length(); i++) {
			char ch = memberName.charAt(i);
			if(ch >= '가' && ch <='힣') {
				count++;
			}
		}		
		boolean condition1 = memberName.length() == count;
		boolean condition2 = memberName.length()>=2 && memberName.length()<=7;
		
		
		if(condition1 &&condition2) {
			this.memberName = memberName;
			}
			else {
				return;
			};
	}
	
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		switch(memberLevel) {
		case "관리자":
		case "우수회원":
		case "일반회원":
		}
		this.memberLevel = memberLevel;
	}
	public int getMemberPoint() {
		return memberPoint;
	}
	public void setMemberPoint(int memberPoint) {
		if(memberPoint <0) return;
		this.memberPoint = memberPoint;
	}
	
	//생성자
	public Member(String memberId, String memberPw, String memberName, String memberLevel, int memberPoint) {
		this.setMemberId(memberId);
		this.setMemberPw(memberPw);
		this.setMemberName(memberName);
		this.setMemberLevel(memberLevel);
		this.setMemberPoint(memberPoint);
	}	
	
	public Member(String memberId, String memberPw, String memberName) {
		this.setMemberId(memberId);
		this.setMemberPw(memberPw);
		this.setMemberName(memberName);
		this.setMemberLevel("일반회원");
		this.setMemberPoint(100);
	}
	
	//출력메소드
	public void show(){
		
		if(this.getMemberId() == null) {
			System.out.println("잘못된 아이디 형식입니다");
		}
		else {
		System.out.println("아이디 : "+this.getMemberId());
		}
		
		if(this.getMemberPw() == null) {
			
			System.out.println("잘못된 비밀번호 형식입니다");
		}
		else {
			String star = "*";
			
			for(int i = 0; i<memberPw.length(); i++){
				int count = memberPw.length();
				memberPw = memberPw.replaceAll("(?<=.{1}).", "*");
			}
			
			System.out.println("비밀번호 : "+this.getMemberPw());
		}
		
		if(this.getMemberName() == null) {
			System.out.println("잘못된 이름 형식입니다");
		}
		else {
		System.out.println("이름 : "+this.getMemberName());
		}
		System.out.println("회원등급 : "+this.getMemberLevel());
		System.out.println("회원포인트 : "+this.getMemberPoint());
	}
}