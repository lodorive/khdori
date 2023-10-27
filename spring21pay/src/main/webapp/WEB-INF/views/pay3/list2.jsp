<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.2/zephyr/bootstrap.min.css" rel="stylesheet">

<h1>결제 내역(계층형)</h1>

<!-- 전체 목록 -->
<c:forEach var="paymentListVO" items="${list}">
	<div style="border:1px solid black; margin:30px 0px; padding:10px">
	
		<!-- 대표 정보 -->
		<table class="table table-warning table-hover">
			<thead>
				<tr>
					<th>구매 아이디</th>
					<th>구매 내역</th>
					<th>결제 금액</th>
					<th>취소 가능 금액</th>
					<th>결제 일자</th>
				</tr>
			</thead>
			
			<tbody>
				<tr>
					<td>${paymentListVO.paymentDto.paymentMember}</td>
					<td>${paymentListVO.paymentDto.paymentName}</td>
					<td>${paymentListVO.paymentDto.paymentPrice}원</td>
					<td>${paymentListVO.paymentDto.paymentRemain}원</td>
					<td>${paymentListVO.paymentDto.paymentTime}</td>
				</tr>
			</tbody>
			
			<%-- 전체취소가 버튼은 잔여금액이 있을 때만 출력되어야 한다 --%>
			<c:if test="${paymentListVO.paymentDto.paymentRemain > 0}">
				<a href="cancelAll?paymentNo=${paymentListVO.paymentDto.paymentNo}" class="float-end">전체(잔여) 금액 취소</a>
			</c:if>
		</div>
		</table>
		
		<!-- 상세 목록 정보 -->
		
			<c:forEach var="paymentDetailDto" items="${paymentListVO.paymentDetailList}">
			<table class="table table-success table-hover">
				<thead>
					<tr>
						<th>상품명</th>
						<th>상품 가격</th>
						<th>수량</th>
						<th>결제상태</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${paymentDetailDto.paymentDetailProductName} </td>
						<td>${paymentDetailDto.paymentDetailProductPrice}원</td>
						<td>${paymentDetailDto.paymentDetailProductQty}개</td>
						<td>결제${paymentDetailDto.paymentDetailStatus}</td>
					</tr>
					<%-- 취소가 가능한 상황일 경우만 개별내역취소 버튼을 출력 --%>
					<c:if test="${paymentDetailDto.paymentDetailStatus == '완료'}">
					<a href="cancel?paymentDetailNo=${paymentDetailDto.paymentDetailNo}" class="float-end">개별내역취소</a>
				</c:if>
				</tbody>					
			</table>
		</c:forEach>
			
		</div>
		
</c:forEach>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>