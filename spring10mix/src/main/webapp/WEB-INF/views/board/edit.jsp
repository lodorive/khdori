<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보 수정</title>
</head>
<body>

	<h1>게시글 수정</h1>
	
	<form action="edit" method="post" autocomplete="off">
	<input type="hidden" name="boardNo" value="${dto.boardNo}">
	제목 <input type="text" name="boardTitle" value="${dto.boardTitle}"> <br><br>
	<!-- (참고) textarea에는 value가 없다 -->
	내용 <textarea name="boardContent" >${dto.boardContent}</textarea><br><br>
	<button>게시글 수정</button>
	</form>
	<h2><a href="list">돌아가기</a></h2>
</body>
</html>