package com.kh.spring03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //애노테이션(Annotation) - 역할 정의
public class QuizController {
	
	//주사위 번호 1개 랜덤
	@RequestMapping("/dice")
	public String dice() {
		Random r = new Random();
		int dice = r.nextInt(6)+1;
		return "주사위 : "+dice;		
	}
	
	//로또 번호 1개 랜덤
	@RequestMapping("/lotto")
	public String lotto() {
		Random r = new Random();
		int lotto = r.nextInt(45)+1;
		return "로또 번호 : "+lotto;
	}
	
	//로또 번호 6개 랜덤
	@RequestMapping("/lotto-list")
	public List<Integer> lottoList() {
		List<Integer> list = new ArrayList<>();
		for(int i=1; i <= 45;i ++) {
			list.add(i);
		}
		Collections.shuffle(list);
		List<Integer> lotto = list.subList(0, 6);
		Collections.sort(lotto);
		return lotto;
	}
	
}
