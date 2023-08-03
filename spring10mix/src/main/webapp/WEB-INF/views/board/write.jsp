<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	
	<h1>게시글 작성</h1>
	
	<form action="write" method="post">
		작성자 <input name="boardWriter"> <br><br>
		제목 <input name="boardTitle"> <br><br>
		내용 <textarea name="boardContent"></textarea> <br><br>
		<button>글쓰기</button>
	</form>
	 		<h2><a href="list">목록으로</a></h2>
</body>
</html>