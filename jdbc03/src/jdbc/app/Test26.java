package jdbc.app;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test26 {
	public static void main(String[] args) {
		
		String memberId = "testuser39";
		
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.selectOne(memberId);
		
		if(dto == null) {
			System.out.println("찾으시는 회원 정보가 없습니다");
		}
		else {
			System.out.println("아이디 : "+dto.getMemberId());
			System.out.println("닉네임 : "+dto.getMemberNickname());
			System.out.println("생년월일 : "+dto.getMemberBirth());
			System.out.println("등급 : "+dto.getMemberLevel());
		}
	}
}
