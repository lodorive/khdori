<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>회원 탈퇴</h2>

<h3>정말 탈퇴하시겠습니까? 탈퇴 후 정보는 삭제됩니다</h3>

<c:if test="${param.error != null}">
	<h3 style="color:red">입력하신 비밀번호가 일치하지 않습니다</h3>
</c:if>

	<form action="exit" method="post" autocomplete="off">
		비밀번호 입력 <input type="password" name="memberPw" required placeholder="비밀번호"><br><br>
		
		<button>탈퇴하기</button>
	</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>