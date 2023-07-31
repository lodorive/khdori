<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>입력창과 폼 만들기</title>
	</head>
	<body>
		<h1>입력창과 폼 만들기</h1>
		
		<!-- 
			form은 데이터 전송을 위한 그룹을 만드는 태그
			- 화면에 표시되지 않는다			
			input은 사용자가 입력할 수 있는 입력창을 만드는 태그
			button은 사용자가 클릭할 수 있는 태그
			- button이 form안에 있으면 전송버튼 역할을 함
			
			입력을 마치고 전송하려면 다음 두 가지가 필요
			[1] 전송할 주소 - form에 작성(action)
			[2] 전송할 데이터의 이름 - input에 작성(name)
		 -->
		 <form action="http://localhost:8080/insert">
		 	번호 : <input name = "no"><br><br>
		 	이름 : <input name = "name"><br><br>
		 	속성 : <input name = "type"><br><br>
		 	<button>등록</button>
		 </form>
		 
	</body>
</html>