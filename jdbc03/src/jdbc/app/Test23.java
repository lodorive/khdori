package jdbc.app;

import java.util.List;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

public class Test23 {
	public static void main(String[] args) {
		
		int page = 1;
		int size = 10;
		
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.selectListByPage(page, size);
		
		if(list.isEmpty()) {
			System.out.println("표시할 항목이 없습니다");
		}
		else {
		for(MemberDto dto : list) {
			System.out.print("["+dto.getMemberId()+"]");
			System.out.println(dto.getMemberNickname());
			}
		}
	}
}
