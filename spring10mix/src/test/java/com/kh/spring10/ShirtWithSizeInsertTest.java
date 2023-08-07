package com.kh.spring10;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring10.dao.ShirtDao;
import com.kh.spring10.dao.ShirtSizeDao;
import com.kh.spring10.dto.ShirtDto;
import com.kh.spring10.dto.ShirtSizeDto;

@SpringBootTest
public class ShirtWithSizeInsertTest {
	@Autowired
	private ShirtDao shirtDao;
	
	@Autowired
	private ShirtSizeDao shirtSizeDao;
	
	@Test
	public void test() {
		//목표 사이즈(M, L, XL)만 존재하는 셔츠를 등록
		//[1] 셔츠 정보 등록
		//[2] M사이즈 정보 등록
		//[3] L사이즈 정보 등록
		//[4] XL사이즈 정보 등록
		
		//[1]
		ShirtDto shirtDto = new ShirtDto();
		shirtDto.setShirtName("사이즈있는옷");
		shirtDto.setShirtColor("블랙");
		shirtDto.setShirtPrice(55000);
		shirtDto.setShirtKind("브이넥");
		shirtDto.setShirtType("반팔");
		shirtDto.setShirtMaterial("면100%");
		shirtDto.setShirtStock(5);
		
		int shirtNo = shirtDao.sequence();
		shirtDto.setShirtNo(shirtNo);
		
		shirtDao.insert(shirtDto);
		
		//[2]
		ShirtSizeDto sizeDto = new ShirtSizeDto();
		sizeDto.setShirtNo(shirtNo);
		sizeDto.setShirtSizeName("M");
		shirtSizeDao.insert(sizeDto);
		
		//[3]
		ShirtSizeDto sizeDto2 = new ShirtSizeDto();
		sizeDto2.setShirtNo(shirtNo);
		sizeDto2.setShirtSizeName("L");
		shirtSizeDao.insert(sizeDto2);
		
		//[4]
		ShirtSizeDto sizeDto3 = new ShirtSizeDto();
		sizeDto3.setShirtNo(shirtNo);
		sizeDto3.setShirtSizeName("XL");
		shirtSizeDao.insert(sizeDto3);
	}
	
	
}
