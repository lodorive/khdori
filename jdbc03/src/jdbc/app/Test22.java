package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test22 {
	public static void main(String[] args) {
		//회원 전체 목록
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectList();
		
		System.out.println("조회 결과 수 : "+list.size());
		
		for(MemberDto dto : list) {
			System.out.print("["+dto.getMemberId()+"]");
			System.out.println(dto.getMemberNickname());
		}
	}
}
