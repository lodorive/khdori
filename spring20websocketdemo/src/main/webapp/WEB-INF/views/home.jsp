<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>채팅 구현</h1>
<!-- 로그인 화면 -->
 <c:choose>
 	<c:when test="${sessionScope.name == null}">
		<form action="login" method="post">
		ID<input type="text" name="memberId">
		<br><br>
		PW<input type="password" name="memberPw">
		<br><br>
		<button type="submit">로그인</button>
		</form>
	</c:when>
	<c:otherwise>
		<a href="logout">로그아웃</a>
	</c:otherwise>
</c:choose>

<h2><a href="sockjs">채팅 입장</a></h2>