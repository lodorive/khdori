package com.kh.spring04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PocketmonController {

	//JdbcTemplate을 직접 만들 수 없다(스프링이 싫어함)
	//설정을 통해서 스프링에게 생성을 요청했으니
	//스프링에게 사용할 수 있도록 "주세요~"(의존성주입) 라고 한다
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//포켓몬스터 등록 서비스
	@RequestMapping("/insert")
	public String insert(
			@RequestParam int no, 
			@RequestParam String name, 
			@RequestParam String type) {
		String sql = "insert into pocketmon(no,name,type)"
						+ "values(?,?,?)";
		Object[] data = {no, name, type};
		jdbcTemplate.update(sql, data);
		return "등록 완료";
	}
	
}
