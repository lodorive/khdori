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
		<!-- 
		내용(boardContent) - 여러줄 입력창(textarea)으로 처리
		 -->
		
		<form action ="http://localhost:8080/insert">
			작성자 : <input name = "boardWriter"> <br><br>
			제목 : <input name = "boardTitle"> <br><br>
<!-- 		내용 : <input name = "boardContent"> <br><br> -->
			내용 : <textarea name="boardContent" rows="10" cols="100"></textarea>
			<button>게시글 등록</button>
		</form>
		
	</body>
</html>