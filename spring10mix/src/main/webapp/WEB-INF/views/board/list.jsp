<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
</head>
<body>
	<h1>자유 게시판</h1>
	<h2>타인에 대한 비방은 경고 없이 삭제됩니다</h2>
	
	<table border="1" width="700">
		<thead>
			<tr>
				<th>번호</th>
				<th width="50%">제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.boardNo}</td>
				<td align="left">
					<a href="detail?boardNo=${dto.boardNo}">
					${dto.boardTitle}
					</a>
				</td>
				<td>${dto.boardWriter}</td>
				<td>${dto.boardReadcount}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>