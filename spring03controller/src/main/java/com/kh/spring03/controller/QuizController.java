package com.kh.spring03.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//파라미터 관련 문제	
	//제곱 문제
	//(추가) 스프링은 역할을 명시하는 것을 선호한다
	// - @RequestParam을 변수 앞에 붙여 파라미터임을 표시
	@RequestMapping("/square")
	public String square(@RequestParam int num) {
		return num+"의 제곱 : "+num*num;
	}
	
	//이용요금 문제
	//(추가) 연도가 주어지지 않으면 실행을 안할건가?
	//- 파라미터가 없어도 실행되어야 하는 상황(ex : 기본값)
	//- 만약 birth가 제공되지 않는다면 성인 요금을 부여
	//- @RequestParam에 required-false 옵션을 주면 없어도 됨
	//- @RequestParam에 defaultValue를 설정하여 기본값을 지정(문자열)
	@RequestMapping("/subway")
	public String subway(@RequestParam(required = false, defaultValue = "2000") int birth) {
		int age = LocalDate.now().getYear()-birth+1;
		
		int price;
		if(age < 8 && age >= 65) 	price = 0;
		else if(age >= 20) 				price = 1250;
		else if(age >= 14) 				price = 720;
		else									price = 450;
		
			return "이용요금은 "+price+"원 입니다";
			
	}
	//윤년 문제
	@RequestMapping("/leap")
	public String leap(@RequestParam int year) {
		boolean isLeap = year % 400 ==0 || (year % 4 ==0 && year % 100 !=0);		
		if(isLeap) {
			return "윤년입니다";
		}
		else{
			return "윤년이 아닙니다";
		}
	}
	//원의 넓이 문제
	@RequestMapping("/circle")
	public String circle(@RequestParam int radius) {
		double area = Math.PI * radius * radius;
		return "원의 넓이 = "+area;
	}
}
