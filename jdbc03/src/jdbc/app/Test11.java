package jdbc.app;

import java.util.Scanner;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test11 {
	public static void main(String[] args) {
		//개인정보 변경 프로그램
		
		Scanner sc = new Scanner(System.in);		
		
		String memberId = "testuser15";
		String memberPw = "Testuser44@";
		String memberNickname = "테스터유저56";
		String memberBirth = "1900-01-01";
		String memberEmail = "test05@testuser.com";
		String membercontact = "01098546215";
		
		MemberDto dto = new MemberDto();
		dto.setMemberPw(memberPw);
		dto.setMemberNickname(memberNickname);
		dto.setMemberBirth(memberBirth);
		dto.setMemberContact(membercontact);
		dto.setMemberEmail(memberEmail);
		dto.setMemberId(memberId);
		
		
		MemberDao dao = new MemberDao();
		boolean result = dao.updateMemberInfo(dto);
		
		if(result) {
			System.out.println("개인 정보가 변경되었습니다");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다");
		}
	}
}
