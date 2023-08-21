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
			<c:choose>
				<c:when test="${sessionScope.name != null}">
					<a href="/" style="text-decoration-line: none;">HOME</a>
					<a href="/member/mypage" style="text-decoration-line: none;">MYPAGE</a>
					<a href="/member/logout" style="text-decoration-line: none;">LOGOUT</a>
					<a href="/board/list" style="text-decoration-line: none;">BOARD</a>
					
					<%-- 관리자인 경우 추가 메뉴 출력 --%>
					<c:if test="${sessionScope.level == '관리자'}">
					<a href="/admin/home">[관리자메뉴]</a>
					</c:if>
				</c:when>
				<c:otherwise>
					<a href="/" style="text-decoration-line: none;">HOME</a>
					<a href="/member/join" style="text-decoration-line: none;">JOIN</a>
					<a href="/member/login" style="text-decoration-line: none;">LOGIN</a>
					<a href="/board/list" style="text-decoration-line: none;">BOARD</a>
				</c:otherwise>
			</c:choose>
		<hr>