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
		<c:when test="${dto != null}">
		<img width="400" src="/여름.jpg">
				<ul>
				<li> 이름 : <th>${dto.shirtName}</th></li> <br>
				<li> 가격 : <th>${dto.shirtPrice}원</th></li> <br>
				<li> 색상 : <th>${dto.shirtColor}</th></li> <br>
				<li> 종류 : <th>${dto.shirtKind}</th></li> <br>
				<li> 유형 : <th>${dto.shirtType}</th></li> <br>
				<li> 재질 : <th>${dto.shirtMaterial}</th></li> <br>
				<li> 수량 : <th>${dto.shirtStock}</th></li> 
				</ul>
		</c:when>
		<c:otherwise>
			<h2>상품이 없습니다</h2>
		</c:otherwise>
		</c:choose>
	<c:if test="${dto != null}">
		<a href="edit?shirtNo=${dto.shirtNo}"><button>상품수정</button></a>
		<a href="delete?shirtNo=${dto.shirtNo}"><button>상품삭제</button></a>
		</c:if>
		<a href="add"><button>등록하기</button></a>
		<a href="list"><button>목록으로</button></a>
</body>
</html>