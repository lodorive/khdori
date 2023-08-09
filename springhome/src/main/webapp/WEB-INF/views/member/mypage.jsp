<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>${memberDto.memberId} 님의 회원 정보</h1>

<table border="1" width="500">
	<tr>
		<th>닉네임</th>
		<td>${memberDto.memberNickname}</td>
	</tr>
	<tr>
		<th>이메일</th>
		<td>${memberDto.memberEmail}</td>
	</tr>
	<tr>
		<th>연락처</th>
		<td>${memberDto.memberContact}</td>
	</tr>
	<tr>
		<th>생년월일</th>
		<td>${memberDto.memberBirth}</td>
	</tr>
	<tr>
		<th>주소</th>
		<td>[${memberDto.memberPost}]
				${memberDto.memberAddr1}
				${memberDto.memberAddr2}
		</td>
	</tr>
	<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
	</tr>
	<tr>
		<th>포인트</th>
<%-- 		<td>${memberDto.memberPoint} pt</td> --%>
		<td>
			<fmt:formatNumber value="${memberDto.memberPoint}"
									pattern="#,##0"></fmt:formatNumber> pt
		</td>
	</tr>
	<tr>
		<th>가입일</th>
<%-- 		<td>${memberDto.memberJoin}</td> --%>
		<td>
			<fmt:formatDate value="${memberDto.memberJoin}"
								pattern="y년 M월 d일 E a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>마지막로그인</th>
<%-- 		<td>${memberDto.memberLogin}</td> --%>
		<td>
		<fmt:formatDate value="${memberDto.memberLogin}"			
		pattern="y년 M월 d일 E a h시 m분 s초"/>
		</td>
	</tr>
	<tr>
		<th>마지막변경일</th>
<%-- 		<td>${memberDto.memberChange}</td> --%>
		<td>
		<fmt:formatDate value="${memberDto.memberChange}"			
		pattern="y년 M월 d일 E a h시 m분 s초"/>
		</td>
	</tr>
</table>

<h4><a href="password">비밀번호 변경</a></h4>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>