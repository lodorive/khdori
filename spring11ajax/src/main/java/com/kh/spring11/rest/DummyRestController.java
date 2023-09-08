package com.kh.spring11.rest;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//CORE를 해제하기 위한 설정(Annotation)
//@CrossOrigin //전부 다 허용(위험)
@CrossOrigin(origins = {"http://192.168.30.46:5500"})
@RestController //@Controller + @ResponseBody
public class DummyRestController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello spring ajax";
	}
	
	//Rest Controller에서는 내가 전해줄 데이터가 반환형이 된다
	//- 자동으로 Spring에서 JSON형태로 변환하여 반환
	//- 변환을 담당하는 라이브러리는 jackson-databind
	@RequestMapping("/lotto")
	public Set<Integer> lotto() {
		Random r = new Random();
		Set<Integer> set = new TreeSet<>();
		while(set.size()<6) {
			int n = r.nextInt(45) + 1;
			set.add(n);
		}
		return set;
	}
	
}
