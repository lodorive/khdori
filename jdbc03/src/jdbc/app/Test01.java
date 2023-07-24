package jdbc.app;

import jdbc.dao.PocketmonDao;
import jdbc.dto.PocketmonDto;

public class Test01 {
	public static void main(String[] args) {
		//포켓몬스터 등록
		
		//데이터
		//int no = 55;
		//String name = "어쩌구";
		//String type = "저쩌구";
		PocketmonDto dto = new PocketmonDto();
		dto.setNo(55);
		dto.setName("얼씨구");
		dto.setType("절씨구");
		
		//처리
		PocketmonDao dao = new PocketmonDao();
		//dao.insert(no, name, type);
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
