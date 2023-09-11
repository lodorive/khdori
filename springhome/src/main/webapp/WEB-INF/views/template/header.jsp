<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dori-house</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="/images/favicon.ico">

 <!-- 아이콘 사용을 위한 Font Awesome 6 CDN-->
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
   
 <!-- 구글 웹 폰트 사용을 위한 CDN -->
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- 스타일시트 로딩 코드 -->
<link rel="stylesheet" type="text/css" href="/css/reset.css">
<link rel="stylesheet" type="text/css" href="/css/layout.css">
<link rel="stylesheet" type="text/css" href="/css/commons.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/test.css"> -->
<style></style>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>
<body>
<main>
        <header>
            <div class="logo">
                <a href="/"><img src="/images/logo.png" width="200px"></a>
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
            		<li><a href="/">HOME</a></li>
            		<li><a href="/member/mypage" >MYPAGE</a></li>
					<li><a href="/member/logout">LOGOUT</a></li>
					<li><a href="/board/list" >BOARD</a></li>
					
					<%-- 관리자인 경우 추가 메뉴 출력 --%>
					<c:if test="${sessionScope.level == '관리자'}">
					<li><a href="/admin/home">[관리자메뉴]</a></li>
					</c:if>
            		</c:when>
            		
            		<c:otherwise>
            		<li><a href="/">HOME</a></li>
            		<li><a href="/member/join" >JOIN</a></li>
					<li><a href="/member/login">LOGIN</a></li>
					<li><a href="/board/list" >BOARD</a></li>
            		</c:otherwise>
            		</c:choose>
            </ul>
        </nav>
        <section>
