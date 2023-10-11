<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>

<!-- css 파일을 불러오는 코드 -->
<!-- 아이콘 사용을 위한 Font Awesome 6 CDN -->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<!-- 구글 웹 폰트 사용을 위한 CDN -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout-sidebar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/test.css"> -->
<style></style>

<script>
	window.contextPath = "${pageContext.request.contextPath}";
</script>

</head>
<body>
	<main>
        <header>
            <div class="logo">
                <img src="https://dummyimage.com/200x50/000/fff">
            </div>
            <div class="title">
                <h1>dori-house</h1>
            </div>
            <div class="etc"></div>
        </header>
        <nav>
            <ul class="menu">
            	<c:choose>
            		<c:when test="${sessionScope.name != null}">
            			<li><a href="${pageContext.request.contextPath}/">Home</a></li>
            			<li><a href="${pageContext.request.contextPath}/member/mypage">내정보</a></li>
            			<li><a href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
            			<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
            			
       					<%-- 관리자인 경우 추가 메뉴 출력 --%>
						<c:if test="${sessionScope.level == '관리자'}">
							<li><a href="${pageContext.request.contextPath}/admin/home">관리자메뉴</a></li>
						</c:if>
            		</c:when>
            		<c:otherwise>
            			<li><a href="${pageContext.request.contextPath}/">Home</a></li>
            			<li><a href="${pageContext.request.contextPath}/member/join">회원가입</a></li>
            			<li><a href="${pageContext.request.contextPath}/member/login">로그인</a></li>
            			<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
            		</c:otherwise>
            	</c:choose>
            </ul>
        </nav>
        <section>
			<aside>
                <div class="flex-container vertical center">
                    <div class="row mv-30">
						<h1>관리자 페이지</h1>
					</div>
					<div class="row">
						<h3><a class="link" href="${pageContext.request.contextPath}/admin/member/list?size=20">회원 관리</a></h3>
					</div>
					<div class="row">
						<h3><a class="link" href="#">회원 통계</a></h3>
					</div>
					<div class="row">
						<h3><a class="link" href="#">게시글 통계</a></h3>
					</div>
                </div>
            </aside>
            <article>