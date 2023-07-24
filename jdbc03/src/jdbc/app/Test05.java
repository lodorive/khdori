package jdbc.app;

import java.sql.Date;

import jdbc.dao.ProductDao;
import jdbc.dto.ProductDto;

public class Test05 {
	public static void main(String[] args) {
		//상품 등록 프로그램
		
		ProductDto dto = new ProductDto();
		dto.setName("바밤바");
		dto.setType("아이스크림");
		dto.setPrice(1500);
		dto.setMade(Date.valueOf("2022-07-01")); //문자열 -> date
		dto.setExpire(Date.valueOf("2022-12-31")); //문자열 -> date
		
		ProductDao dao = new ProductDao();
		dao.insert(dto);
		
		System.out.println("등록 완료!");
	}
}
