<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
	<h1>상품 정보</h1>
		<c:choose>
		<c:when test="${shirtDto != null}">
		<img width="400" src="/여름.jpg">
				<ul>
				<li> 이름 : <th>${shirtDto.shirtName}</th></li> <br>
				<li> 가격 : <th>${shirtDto.shirtPrice}원</th></li> <br>
				<li> 색상 : <th>${shirtDto.shirtColor}</th></li> <br>
				<li> 종류 : <th>${shirtDto.shirtKind}</th></li> <br>
				<li> 유형 : <th>${shirtDto.shirtType}</th></li> <br>
				<li> 재질 : <th>${shirtDto.shirtMaterial}</th></li> <br>
				<li> 수량 : <th>${shirtDto.shirtStock}</th></li><br>
				<li> 보유 사이즈 </li>
				<th><c:forEach var="sizeDto" items="${sizeList}">
						${sizeDto.shirtSizeName}
				</c:forEach> </th><br>
				</ul>
		</c:when>
		<c:otherwise>
			<h2>상품이 없습니다</h2>
		</c:otherwise>
		</c:choose>
	<c:if test="${shirtDto != null}">
		<a href="edit2?shirtNo=${shirtDto.shirtNo}"><button>상품수정</button></a>
		<a href="delete?shirtNo=${shirtDto.shirtNo}"><button>상품삭제</button></a>
		</c:if>
		<a href="add2"><button>등록하기</button></a>
		<a href="list"><button>목록으로</button></a>
</body>
</html>