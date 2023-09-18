<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<form action="findPw" method="post">
<div class="container w-400">
	<div class="row">
		<h2>비밀번호 찾기</h2>
		<div class="row">
			아이디 <input type="text" name="memberId" class="form-input" required>
		</div>
		<div class="row">
			이메일 <input type="email" name="memberEmail" class="form-input" required>
		</div>
		<div class="row">
		 	<button type="submit" class="btn">비밀번호 찾기</button>
		</div>
	</div>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>