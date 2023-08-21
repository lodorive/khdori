<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
    <body>
    <h3>${memberDto.memberId} 회원 정보</h3>
	<table border="1" width="600">
	<tr>
    <th>아이디</th>
    <td>${memberDto.memberId}</td>
    </tr>
    <tr>
     <th>닉네임</th>
     <td>${memberDto.memberNickname}</td>
     </tr>
     <tr>
     <th>이메일</th>
     <td>${memberDto.memberEmail}</td>
     </tr>
     <tr>
     <th>전화번호</th>
     <td>${memberDto.memberContact}</td>
     </tr>
     <tr>
     <th>생년월일</th>
     <td>${memberDto.memberBirth}</td>
     </tr>
     <tr>
     <th>주소</th>
     <td>${memberDto.memberPost}
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
     <td>${memberDto.memberPoint}</td>
     </tr>
     <tr>
     <th>가입일</th>
     <td>${memberDto.memberJoin}</td>
     </tr>
     <tr>
     <th>마지막로그인</th>
     <td>${memberDto.memberLogin}</td>
     </tr>
     <tr>
     <th>마지막변경일</th>
     <td>${memberDto.memberChange}</td>
     </tr>
    </table>
    <br>
    <a href="list">목록</a>
	<a href="edit">수정</a>
   </body> 
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>