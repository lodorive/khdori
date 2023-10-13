package com.kh.spring17.configuration;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class EmptyStringControllerAdvice {

	@InitBinder
	public void customBinding(WebDataBinder binder) {
		//binder.registerCustomEditor(자료형, 처리도구);
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
}
