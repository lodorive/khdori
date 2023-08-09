<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<hr>
		KH정보교육원 웹개발자 양성과정<br><br>
		
					<%--
				JSP에서 세션에 저장된 값을 확인하려면 EL의 내장객체를 사용
				sessionScope 내장객체를 사용하면 HttpSession의 값을 조회할 수 있다
			 --%>
			세션ID = ${pageContext.session.id},
			세션값 = ${sessionScope.name}<br>
			<%-- 
				이 페이지는 조각일 뿐이므로 어디서 실행될지 모른다 
				여기서 작성되는 경로는 무조건 절대경로여야 한다
			--%>
	</div>
</body>
</html>