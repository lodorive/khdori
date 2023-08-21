package com.kh.springhome.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.springhome.error.AuthorityException;

@Component
public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String memberLevel = (String) session.getAttribute("level");
		boolean admin = memberLevel == "관리자";
		
		if(admin) {
			return true;
		}
		else {
			throw new AuthorityException("관리자만 이용 가능");
		}
	}
	
}
