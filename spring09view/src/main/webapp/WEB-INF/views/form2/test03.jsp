<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>회원 탈퇴</title>
	</head>	
	<body>
		<h1>회원 탈퇴</h1>
		<h2>탈퇴를 위한 정보를 입력해주세요</h2>
		
		<form action="http://localhost:8080/member/exit" method="post">	
		아이디		<input type="text" name="memberId" required> <br><br>
		비밀번호		<input type="password" name="memberPw" required> <br><br>	 		
		<button>탈퇴완료</button>		
		</form>

	</body>
</html>