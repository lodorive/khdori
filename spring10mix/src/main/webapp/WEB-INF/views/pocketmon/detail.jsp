<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--
    	페이지 내에서 프로그래밍 처리를 할 수 있는
    	추가 도구를 사용하도록 설정
     --%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>${dto.no}번 몬스터 정보</title>
	</head>
	<body>
	
		<c:choose>
			<c:when test="${dto != null}">
				<h2>이름 : ${dto.name}</h2>
				<h2>속성 : ${dto.type}</h2>
			</c:when>
			<c:otherwise>
				<h1>미안! 없나봐</h1>
			</c:otherwise>
		</c:choose>

	</body>
</html>