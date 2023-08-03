<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.boardNo}번 게시글 정보</title>
</head>
	
	<body>
		<h1>${dto.boardNo}번 게시글</h1>
		<table border="1" width="500">
	<c:choose>
		<c:when test="${dto != null}">
			<th width="25%">제목</th> 
			<td>${dto.boardTitle}</td>
			<tr>
			<th>내용</th>
			<td>${dto.boardContent}</td>
			</tr>
			<tr>
			<th>작성자</th>
			<td>${dto.boardWriter}</td>
			</tr>
			<tr>
			<th>조회수</th>
			<td>${dto.boardReadcount}</td>			
			</tr>	
			</table>
		</c:when>
		<c:otherwise>
			<h2>게시글이 없습니다</h2>
		</c:otherwise>
		</c:choose>	
		
		<c:if test="${dto != null}">
		<a href="edit?boardNo=${dto.boardNo}">게시글 수정</a>
		</c:if>
		<a href="list">돌아가기</a>
	</body>

</html>