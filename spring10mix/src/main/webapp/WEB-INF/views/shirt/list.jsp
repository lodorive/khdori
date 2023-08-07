<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의류 목록</title>
</head>
<body align="center"  bgcolor="#c7ecee">
	<h1 style="color:#fd79a8;">상품 리스트</h1>
	<a href="add2" ><button>▷ 상품등록 ◁</button></a><br><br>
	
		<table border="1" width="450"  align="center" > 
		<thead >
		<img width="450" src="/여름.jpg">
		<c:forEach var="dto" items="${list}">	
		<tr>
		<td align="center"  bgcolor="#fd79a8">
		<a href="detail2?shirtNo=${dto.shirtNo}">
		${dto.shirtName}<br>
		${dto.shirtColor}<br>
		${dto.shirtPrice}원<br>
		${dto.shirtKind}<br>
		${dto.shirtType}<br>
		</td>	
		</tr>
			</c:forEach>
		</table>
</body>
</html>