<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dori-house</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">

 <!-- 아이콘 사용을 위한 Font Awesome 6 CDN-->
 <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
   
 <!-- 구글 웹 폰트 사용을 위한 CDN -->
 <link rel="preconnect" href="https://fonts.googleapis.com">
 <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
 <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">

<!-- 부트스트랩 CDN -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.2/zephyr/bootstrap.min.css" rel="stylesheet">
    
<!-- 스타일시트 로딩 코드 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/layout.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/commons.css">
<!-- <link rel="stylesheet" type="text/css" href="/css/test.css"> -->
<style></style>

<%-- 
	절대경로를 설정하기 위한 스크립트 작성
	- 절대경로라는 개념은 백엔드에만 있다
	- 자바스크립트에서 절대경로를 알 수 있는 방법이 없다
	- window에 절대경로 값을 탑재시켜 사용
--%>
    
<script>
	window.contextPath = "${pageContext.request.contextPath}";
</script>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

</head>
<body>
<main>
<header>
   <div class="container-fluid">
        <div class="row">
            <div class="col-md-10 offset-md-1">

                <!-- 메뉴바 -->
                <nav class="navbar navbar-expand-lg bg-success fixed-top" data-bs-theme="light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="${pageContext.request.contextPath}/">dori-house</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false"
                            aria-label="Toggle navigation"> <!-- 이 버튼을 누르면 메뉴를 아래로 떨어뜨림 target이 대상 -->
                            <span class="navbar-toggler-icon"></span> <!-- 메뉴 아이콘(크기 줄였을 때 메뉴바)-->
                        </button>
                        <div class="collapse navbar-collapse" id="navbarColor03"> <!-- 위 타겟이랑 연결 -->
                            <ul class="navbar-nav me-auto"> <!-- 실제 메뉴 -->
                                <c:choose>
                                    <c:when test="${sessionScope.name != null}">
                                <li class="nav-item">
                                    <a class="nav-link active" href="${pageContext.request.contextPath}/">Home <!-- active는 활성화 메뉴(기본 선택되어 있는) -->
                                        <span class="visually-hidden">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/member/mypage">mypage</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/member/logout">logout</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/board/list">board</a>
                                </li>
                                <%-- 관리자인 경우 추가 메뉴 출력 --%>
					            <c:if test="${sessionScope.level == '관리자'}">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="${pageContext.request.contextPath}/admin/home" role="button"
                                        aria-haspopup="true" aria-expanded="false">admin</a>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/member/list?size=20">회원관리</a>
                                        <a class="dropdown-item" href="#">회원통계</a>
                                        <a class="dropdown-item" href="#">게시글통계</a>
                                </li>
                            </c:if>
                        </c:when>

                            <c:otherwise>
                                <li class="nav-item">
                                    <a class="nav-link active" href="${pageContext.request.contextPath}/">Home <!-- active는 활성화 메뉴(기본 선택되어 있는) -->
                                        <span class="visually-hidden">(current)</span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/member/join">join</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/member/login">login</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/board/list">board</a>
                                </li>
                            </c:otherwise>
                            </c:choose>

                            </ul>
                            <form class="d-flex"> <!-- display:flex -->
                                <input class="form-control me-sm-2" type="search" placeholder="Search">
                                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </nav>

                <!-- 내용(배너, 컨텐츠 등)을 배치할 때는 margin top을 줘서 메뉴가 표시될 자리만큼 띄워야 한다 -->
                <div class="row mt-5 pt-5" style="min-height: 400px;">
                    <div class="col-sm-10 offset-sm-1"> <!-- header.jsp -->
<section>
