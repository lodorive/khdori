<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<form>
	<div>도서번호 <input type="text" name="bookId" value="${vo.bookId}"></div>
	<div>도서명<input type="text" name="bookTitle" value="${vo.bookTitle}"></div>
	<button type="submit">검색</button>
</form>

<hr>

<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>출간일</th>
			<th>판매가</th>
			<th>페이지</th>
			<th>장르</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="bookDto" items="${list}">
		<tr>
			<td>${bookDto.bookId}</td>
			<td>${bookDto.bookTitle}</td>
			<td>${bookDto.bookAuthor}</td>
			<td>${bookDto.bookPublisher}</td>
			<td>${bookDto.bookPublicationDate}</td>
			<td>${bookDto.bookPrice}</td>
			<td>${bookDto.bookPageCount}</td>
			<td>${bookDto.bookGenre}</td>
		</tr>
			</c:forEach>
	</tbody>
</table>

