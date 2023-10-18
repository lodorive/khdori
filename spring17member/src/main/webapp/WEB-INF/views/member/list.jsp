<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
 <form>
 	<div>아이디 <input type="text" name="memberId" value="${vo.memberId}"></div>
 	<div>닉네임 <input type="text" name="memberNickname" value="${vo.memberNickname}"></div>
 	<div>전화번호 <input type="tel" name="memberContact" value="${vo.memberContact}"></div>
 	<div>이메일 <input type="email" name="memberEmail" value="${vo.memberEmail}"></div>
 	<div>생일 </div>
 	<div>등급</div>
 	<div>포인트</div>
 	<div>가입 일자</div>
 	<div>로그인 일자</div>
 	<button type="submit">검색</button>
 </form>   
    
<table border="1">
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>생일</th>
			<th>주소</th>
			<th>등급</th>
			<th>포인트</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberDto" items="${list}">
		<tr>
			<td>${memberDto.memberId}</td>
			<td>${memberDto.memberNickname}</td>
			<td>${memberDto.memberContact}</td>
			<td>${memberDto.memberEmail}</td>
			<td>${memberDto.memberBirth}</td>
			<td>[${memberDto.memberPost}]
					${memberDto.memberAddr1}
					${memberDto.memberAddr2}
			</td>
			<td>${memberDto.memberLevel}</td>
			<td>${memberDto.memberPoint}</td>
			<td>${memberDto.memberJoin}</td>
		</tr>
			</c:forEach>
	</tbody>
</table>