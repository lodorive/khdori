<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>

	<h1>도서 목록 조회</h1>
	<h2><a href="insert">신규등록</a></h2>
	
	<table border="1" width="700">
		<thead>
			<tr>
				<th>코드</th>
				<th>제목</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>메뉴</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.bookId}</td>
				<td>
				<a href="detail?bookId=${dto.bookId}">
				${dto.bookTitle}
				</a>
				</td>
				<td>${dto.bookAuthor}</td>
				<td>${dto.bookPublisher}</td>
				<td>$${dto.bookPrice}</td>
				<td>
				<a href="delete?bookId=${dto.bookId}">삭제</a> <br>
				</td>
			</tr>	
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>