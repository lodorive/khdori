package com.kh.spring14;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.spring14.dto.PocketmonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test01 {
	
	//Spring JDBC
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
	
	//myBatis
	@Autowired
	private SqlSession sqlSession; 
	
	@Test
	public void test() {
		//구문을 어딘가(mapper)에 저장해두고 불러와서 사용
		List<PocketmonDto> list = sqlSession.selectList("pocketmon.list");
		log.debug("개수 = {}", list.size());
		
		for(PocketmonDto dto:list) {
			log.debug("dto = {}", dto);
		}
	}
}
