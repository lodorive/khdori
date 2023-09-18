<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<form action="findPw" method="post" autocomplete="off">
<div class="container w-300">
	<div class="row mb-30">
		<h2>비밀번호 찾기</h2>
		<div class="row mt-30">
			<input type="text" name="memberId" class="form-input w-100" placeholder="아이디" required>
		</div>
		<div class="row">
			<input type="email" name="memberEmail" class="form-input w-100" placeholder="이메일" required>
		</div>
		<div class="row">
		 	<button type="submit" class="btn btn-positive w-100">비밀번호 찾기</button>
		</div>
	</div>
</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>