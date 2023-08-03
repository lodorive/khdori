<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포켓몬 정보 수정</title>
</head>
<body>
	
	<h1>포켓몬 정보 수정</h1>
	
	<!-- 
		번호의 경우는 전송은 하지만 수정이 불가해야 한다
		1. 입력창에 readonly 속성 추가
		2. 입력창을 숨김으로 생성
	 -->
	
	<form action="edit" method="post">
		<%-- 번호 <input type="text"  name="no" value="${dto.no}" readonly> <br><br> --%>
		<input type="hidden" name="no" value"${dto.no}">
		이름 <input type="text"  name="name" value="${dto.name}"> <br><br>
		속성 <input type="text"  name="type" value="${dto.type}"> <br><br>
		<button>변경하기</button>
	</form>
	
</body>
</html>