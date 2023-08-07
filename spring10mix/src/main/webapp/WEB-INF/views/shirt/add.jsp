<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<h1>상품 등록</h1>
	
	<form action="add" method="post" autocomplete="off">
		이름 <input name="shirtName" required> <br><br>
		색상 <select name="shirtColor" required>
		<!-- 
			option에 value를 주면 표시되는 값과 다르게 전송을 한다
		 -->
			<option value="">색상선택</option>
			<option>블랙</option>
			<option>화이트</option>
			<option>그레이</option>
			<option>레드</option>
			<option>블루</option>
		</select> <br><br>
		가격 <input type="number" name="shirtPrice" required> <br><br>
		종류 <select name="shirtKind" required>
			<option value="">종류선택</option> 
			<option>라운드</option>
			<option>브이넥</option>
			<option>정장</option>
		</select>
		<br><br>
		유형 <select name="shirtType" required> 
			<option value="">유형선택</option>
			<option>민소매</option>
			<option>반팔</option>
			<option>긴팔</option>
		</select>
		<br><br>
		재질 <textarea name="shirtMaterial"> 
		</textarea>
		<br><br>
		수량 <input type="number" name="shirtStock" required> <br><br>
		<button>등록하기</button>
	</form>
	
		<h5><a href="list">목록으로</a></h5>
</body>
</html>