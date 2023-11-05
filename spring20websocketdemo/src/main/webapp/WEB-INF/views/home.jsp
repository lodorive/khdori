<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>웹소켓 실습 예제</h1>

<!-- <h2><a href="default">기본 웹서버 예제</a></h2> -->
<!-- <h2><a href="time">타임 웹서버 예제</a></h2> -->
<!-- <h2><a href="group">그룹 웹서버 예제</a></h2> -->

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

<!-- <h2><a href="member">회원 전용 웹소켓 예제</a></h2> -->
<!-- <h2><a href="json">회원 전용 웹소켓 예제(+JSON)</a></h2> -->
<h2><a href="sockjs">SockJS를 사용한 웹소켓 예제</a></h2>