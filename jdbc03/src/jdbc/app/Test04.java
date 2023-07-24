package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test04 {
	public static void main(String[] args) {
		//회원 가입
		
		MemberDto dto = new MemberDto();
		dto.setMemberId("testuser5");
		dto.setMemberPw("Testuser5!");
		dto.setMemberNickname("테스트유저5");
		dto.setMemberBirth("2022-05-05");
		dto.setMemberEmail(null);
		dto.setMemberContact("01012364456");
		
		MemberDao dao = new MemberDao();
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
