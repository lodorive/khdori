<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>컨트롤러 연동 예제</title>
	</head>
	
	<body>
		<%--
			컨트롤러에서 전달한 모델에 담겨있는 데이터를 가져다가 화면에 출력			
		 	
		 	${전달된이름} or ${requestScope.전달된이름}
		 	
		 	이러한 방식을 EL(Expression Language, 표현 언어)라고 부른다
		 --%>
		 
		 <h1>주사위 : ${dice}</h1>
	</body>
	
</html>