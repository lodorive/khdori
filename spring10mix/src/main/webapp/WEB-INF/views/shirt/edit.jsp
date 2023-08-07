<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정</title>
</head>
<body>
	<h1>상품 정보 수정</h1>
		<form action="edit" method="post" autocomplete="off">
			<input type="hidden" name="shirtNo" value="${dto.shirtNo}"> 

			이름 <input name="shirtName" value="${dto.shirtName}" required> <br><br>
			색상 <select name="shirtColor" value="${dto.shirtColor}" required> 
			<option value="">색상선택</option>
			<option value="블랙">블랙</option>
			<option value="화이트">화이트</option>
			<option value="그레이">그레이</option>
			<option value="레드">레드</option>
			<option value="블루">블루</option>
			</select>
			<br><br>
			가격 <input type="number" name="shirtPrice" value="${dto.shirtPrice}" required> <br><br>
			종류 <select name="shirtKind" value="${dto.shirtKind}" required>
			<option value="">종류선택</option> 
			<option value="라운드">라운드</option>
			<option value="브이넥">브이넥</option>
			<option value="정장">정장</option>
			</select><br><br>
			유형 <select name="shirtType" value="${dto.shirtType}" required>
			<option value="">유형선택</option>
			<option value="민소매">민소매</option>
			<option value="반팔">반팔</option>
			<option value="긴팔">긴팔</option>
			</select><br><br>
			재질 <input name="shirtMaterial" value="${dto.shirtMaterial}"> <br><br>
			수량 <input type="number" name="shirtStock" value="${dto.shirtStock}" required> <br><br>
			
			<button>수정하기</button>
			<button><a href="detail?shirtNo=${dto.shirtNo}">돌아가기</a></button>
		</form>	
</body>
</html>