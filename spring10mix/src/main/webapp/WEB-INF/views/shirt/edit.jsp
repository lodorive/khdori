<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<%--
				EL의 특징
				- 외따옴표, 쌍따옴표 모두 문자열로 취급
				- 문자열도 비교연산이 가능
			 --%>
			<c:choose>			
				<c:when test="${dto.shirtColor == '블랙'}">
			<option selected>블랙</option>
				</c:when>
				<c:otherwise>
			<option>블랙</option>
			 </c:otherwise>
			</c:choose>
			
					<c:choose>
				<c:when test="${dto.shirtColor == '화이트'}">
			<option selected>화이트</option>
				</c:when>
				<c:otherwise>
			<option>화이트</option>
			 </c:otherwise>
			</c:choose>
			
					<c:choose>
				<c:when test="${dto.shirtColor == '그레이'}">
			<option selected>그레이</option>
				</c:when>
				<c:otherwise>
			<option>그레이</option>
			 </c:otherwise>
			</c:choose>
			
					<c:choose>
				<c:when test="${dto.shirtColor == '레드'}">
			<option selected>레드</option>
				</c:when>
				<c:otherwise>
			<option>레드</option>
			 </c:otherwise>
			</c:choose>
			
					<c:choose>
				<c:when test="${dto.shirtColor == '블루'}">
			<option selected>블루</option>
				</c:when>
				<c:otherwise>
			<option>블루</option>
			 </c:otherwise>
			</c:choose>
			
			</select>
			<br><br>
			가격 <input type="number" name="shirtPrice" value="${dto.shirtPrice}" required> <br><br>
			종류 <select name="shirtKind" value="${dto.shirtKind}" required>
			<option value="">종류선택</option> 
			
			<c:choose>
				<c:when test="${dto.shirtKind == '라운드'}">
			<option selected>라운드</option>
				</c:when>
				<c:otherwise>
			<option>라운드</option>
			 </c:otherwise>
			</c:choose>
			
				<c:choose>
				<c:when test="${dto.shirtKind == '브이넥'}">
			<option selected>브이넥</option>
				</c:when>
				<c:otherwise>
			<option>브이넥</option>
			 </c:otherwise>
			</c:choose>
			
				<c:choose>
				<c:when test="${dto.shirtKind == '정장'}">
			<option selected>정장</option>
				</c:when>
				<c:otherwise>
			<option>정장</option>
			 </c:otherwise>
			</c:choose>
			</select><br><br>
			
			유형 <select name="shirtType" value="${dto.shirtType}" required>
			<option value="">유형선택</option>
			
				<c:choose>
				<c:when test="${dto.shirtType == '민소매'}">
			<option selected>민소매</option>
				</c:when>
				<c:otherwise>
			<option>민소매</option>
			 </c:otherwise>
			</c:choose>
			
				<c:choose>
				<c:when test="${dto.shirtType == '반팔'}">
			<option selected>반팔</option>
				</c:when>
				<c:otherwise>
			<option>반팔</option>
			 </c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${dto.shirtType == '긴팔'}">
			<option selected>긴팔</option>
				</c:when>
				<c:otherwise>
			<option>긴팔</option>
			 </c:otherwise>
			</c:choose>
			
			</select><br><br>
			재질 <input name="shirtMaterial" value="${dto.shirtMaterial}"> <br><br>
			수량 <input type="number" name="shirtStock" value="${dto.shirtStock}" required> <br><br>
			
			<button>수정하기</button>
			<button><a href="detail?shirtNo=${dto.shirtNo}">돌아가기</a></button>
		</form>	
</body>
</html>