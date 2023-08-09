<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dori-house</title>
</head>
<body>
	<div align="center">
		<a href="/" style="text-decoration-line: none;"><h1>dori-house</h1></a>
		<hr>
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
			<c:choose>
				<c:when test="${sessionScope.name != null}">
					<a href="/" style="text-decoration-line: none;">홈</a>
					<a href="/member/mypage" style="text-decoration-line: none;">마이페이지</a>
					<a href="/member/logout" style="text-decoration-line: none;">로그아웃</a>
					<a href="/board/list" style="text-decoration-line: none;">게시판</a>
				</c:when>
				<c:otherwise>
					<a href="/" style="text-decoration-line: none;">홈</a>
					<a href="/member/join" style="text-decoration-line: none;">회원가입</a>
					<a href="/member/login" style="text-decoration-line: none;">로그인</a>
					<a href="/board/list" style="text-decoration-line: none;">게시판</a>
				</c:otherwise>
			</c:choose>
		<hr>