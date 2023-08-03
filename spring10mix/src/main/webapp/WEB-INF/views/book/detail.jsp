<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>도서 정보</title>
	</head>	
	<body>
		<c:choose>
			<c:when test="${dto != null}">
				<thead>
				<h1>도서 정보</h1>
				<!-- 
					리스트 태그
					- 외부에 <ul> 또는 <ol>을 사용
						-ul은 순서가 없는 리스트(unorder list)
						-ol은 순서가 있는 리스트(order list)
					- 내부에 <li>를 사용 (list item)
				 -->
				<ul>
					<li>${dto.bookTitle}</li>
					<li>${dto.bookAuthor}</li>
					<li>${dto.bookPublicationDate}</li>
					<li>${dto.bookPrice}</li>
					<li>${dto.bookPublisher}</li>
					<li>${dto.bookPageCount}</li>
					<li>${dto.bookGenre}</li>
				</ul>	
				
				<table border ="1" width="500">
				</thead>
				<tbody align="center">
				<tr>
				<th>제목</th>
				<td>${dto.bookTitle}</td>
				</tr>
				<tr>
				<th>저자</th> 
				<td>${dto.bookAuthor}</td>
				</tr>
				<tr>
				<th>출판일</th> 
				<td>${dto.bookPublicationDate}</td>
				</tr>
				<tr>
				<th>가격</th>
				<td>${dto.bookPrice}</td>
				</tr>
				<tr>
				<th>출판사</th>
				<td>${dto.bookPublisher}</td>
				</tr>
				<tr>
				<th>페이지수</th> 
				<td>${dto.bookPageCount}</td>	
				<tr>	
				<th>장르</th>
				<td>${dto.bookGenre}</td>
				</tbody>
				</table>
		</c:when>
		<c:otherwise>
				<h1>찾으시는 도서가 없습니다</h1>
		</c:otherwise>		
		</c:choose>
			<h2><a href="list">돌아오기</a></h2>
	</body>
</html>