<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 매번 페이지 코드를 복사할 수 없으니 미리 만든 것을 불러오도록 설정 
		- 템블릿 페이지(template page)라고 부름
		- 절대경로를 사용할 것
--%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
			
<h2>Hello!</h2>		
<img src="https://img.gqkorea.co.kr/gq/2023/08/style_64cb1badf3c78-600x400.jpg">
		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>