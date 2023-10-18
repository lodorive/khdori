package com.kh.spring14;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test07 {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		Map<String, Object> param = new HashMap<>();
//		param.put("no", 1);
//		param.put("name", "마임");
//		param.put("type", "마임");

//		List<PocketmonDto> list = sqlSession.selectList("pocketmon.complex2", param);
		List<PocketmonDto> list = sqlSession.selectList("pocketmon.complex3", param);
		
		log.debug("결과 = {}", list.size());
		for(PocketmonDto dto:list) {
			log.debug("dto={}", dto);
		}
	}
}
