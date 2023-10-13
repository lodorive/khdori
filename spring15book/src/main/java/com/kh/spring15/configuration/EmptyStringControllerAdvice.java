package com.kh.spring15.configuration;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//목표 : empty string을 컨트롤러가 null로 해석하도록 설정
@ControllerAdvice
public class EmptyStirngControllerAdvice {

	@InitBinder
	public void customBinding(WebDataBinder binder) {
//		binder.registerCustomEditor(자료형, 처리도구);
	}
	
}
