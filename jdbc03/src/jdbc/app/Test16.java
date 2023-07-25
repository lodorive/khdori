package jdbc.app;

import jdbc.dao.MemberDao;

public class Test16 {
	public static void main(String[] args) {
		
		String memberId = "testuser1";
		
		MemberDao dao = new MemberDao();
		boolean result = dao.delete(memberId);
		
		if(result) {
			System.out.println("회원 아이디 삭제 완료");
		}
		else {
			System.out.println("존재하지 않는 회원 아이디");
		}
	}
}
