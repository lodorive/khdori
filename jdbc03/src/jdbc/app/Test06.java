package jdbc.app;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test06 {
	public static void main(String[] args) {
		//Pocketmon 정보수정
		
		//데이터 준비 - DTO
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(3);
		dto.setName("이상해꽃");
		dto.setType("독");
		
		//DB처리
		PocketmonDao dao = new PocketmonDao();
		boolean result = dao.update(dto);
		
		if(result) {
			System.out.println("변경 완료");
		}
		else {
			System.out.println("존재하지 않는 몬스터 번호");
		}
	}
}
