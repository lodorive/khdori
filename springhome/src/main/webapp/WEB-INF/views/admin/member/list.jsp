<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h4>회원 관리</h4>
	<!-- 검색창 -->
	<form action="list" method="get">
	<c:choose>
		<c:when test="${vo.type == 'member_nickname'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname" selected>닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_contact'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact" selected>전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_email'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email" selected>이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_birth'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth" selected>생년월일</option>
			</select>
		</c:when>
		<c:otherwise>
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:otherwise>
	</c:choose>


	<input type="search" name="keyword" placeholder="검색어" 
		value="${vo.keyword}" required autocomplete="off">
	<button>검색</button>
</form>
<br>
<c:if test="${vo.search}">
<h5>&quot;${vo.keyword}&quot;에 대한 검색 결과</h5>
</c:if>
	<table border="1" width="800">
		<thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>생년월일</th>
				<th>등급</th>
				<th>메뉴</th>
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="memberDto" items="${list}">
		<tr>
				<td>${memberDto.memberId}</td>
				<td>${memberDto.memberNickname}</td>
				<td>${memberDto.memberContact}</td>
				<td>${memberDto.memberEmail}</td>
				<td>${memberDto.memberBirth}</td>
				<td>${memberDto.memberLevel}</td>
				<td>
					<a href="detail?memberId=${memberDto.memberId}">상세</a>
					<a href="edit?memberId=${memberDto.memberId}">수정</a>
					<a href="#">차단</a>
				</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		
		<br>
		
<!-- 이전 버튼 -->
<c:if test="${!vo.first}">
	<a href="list?${vo.prevQueryString}">&lt;</a>
</c:if>

<!-- 숫자 버튼 -->
<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
<a href="list?${vo.getQueryString(i)}">${i}</a>
</c:forEach>

<!-- 다음 버튼 -->
<c:if test="${!vo.last}">
	<a href="list?${vo.nextQueryString}">&gt;</a>
</c:if>
		
		<br><br>
	
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>