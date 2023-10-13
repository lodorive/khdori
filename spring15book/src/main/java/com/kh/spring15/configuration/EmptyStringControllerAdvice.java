package com.kh.spring15.configuration;

import java.beans.PropertyEditorSupport;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

//목표 : empty string을 컨트롤러가 null로 해석하도록 설정
@ControllerAdvice
public class EmptyStringControllerAdvice {

	@InitBinder
	public void customBinding(WebDataBinder binder) {
		//binder.registerCustomEditor(자료형, 처리도구);
		//[1] 문자열 파라미터가 전송될 때 빈 문자열("")을 null로 처리되도록 설정
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		//[2] List 파라미터(a=1&a=2&a=3)가 비어있는 값일 경우 이것이 추가되지 않도록 설정
				//- 기존에 제공되는 도구 중에 존재하지 않아서 상속받아서 신규 객체로 생성
				binder.registerCustomEditor(List.class, new PropertyEditorSupport() {
					@Override
					public void setAsText(String text) throws IllegalArgumentException {
						String convert = text.replace(",", "").trim();
						setValue(convert.isEmpty() ? List.of() : Arrays.stream(text.split(",")).toList());
					}
				});
			}
	
}