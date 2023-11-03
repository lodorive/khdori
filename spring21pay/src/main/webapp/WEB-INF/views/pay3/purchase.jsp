<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>

<!-- favicon 설정 -->
<link rel="shortcut icon" href="/images/favicon.ico">

<!-- css 파일을 불러오는 코드 -->
<!-- 아이콘 사용을 위한 Font Awesome 6 CDN -->
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

<!-- 구글 웹 폰트 사용을 위한 CDN -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin="">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&amp;display=swap" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.2/sandstone/bootstrap.min.css" rel="stylesheet">

<style></style>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<!-- Bootstrap CDN -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>

<body>
	<div class="container-fluid mb-5 pb-5">
        <div class="row">
            <div class="col-md-10 offset-md-1">

            
<div class="mt-4 p-4 text-light bg-dark rounded">
	<h1>결제 정보 확인</h1>
	<p>
		구매하실 상품의 금액을 다시 확인하세요 
	</p>
</div>

<div class="row mt-2">
	<div class="col">
		<table class="table">
			<thead>
				<tr>
					<th width="40%">상품명</th>
					<th class="text-end">판매가</th>
					<th class="text-end">수량</th>
					<th class="text-end">금액</th>
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td>처음처럼</td>
					<td class="text-end"></td>
					<td class="text-end">7</td>
					<td class="text-end">8,400원</td>
				</tr>
				
			</tbody>
		</table>
	</div>
</div>

<div class="row mt-4">
	<div class="col text-end">
		<h2>
		총 8,400원
		</h2>
	</div>
</div>

<div class="row mt-4">
	<div class="col">
		<!-- 전송되는 부분 -->
		<form method="post">
			
				<input type="hidden" name="product[0].productNo" value="1">
				<input type="hidden" name="product[0].qty" value="7">
			
			<button type="submit" class="btn btn-primary btn-lg w-100">
				<i class="fa-solid fa-cart-shopping"></i>
				구매하기
			</button>
		</form>
	</div>
</div>

				</div>
			</div>
		</div>

</body>