<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
 <h2>회원정보 변경</h2>
<form action="edit" method="post" autocomplete="off">

 		아이디 ${memberDto.memberId}<br>
 		닉네임 <input type="text" name="memberNickname" value="${memberDto.memberNickname}"><br>
		이메일 <input type="email" name="memberEmail" value="${memberDto.memberEmail}" > <br>
		전화번호 <input type="tel" name="memberContact" value="${memberDto.memberContact}" > <br>
		생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}" > <br>
		주소 <br>
		<input type="text" name="memberPost" size="6" maxlength="6"
			placeholder="우편번호" value="${memberDto.memberPost}"><br>
		<input type="text" name="memberAddr1" size="30" 
			placeholder="기본주소" value="${memberDto.memberAddr1}"><br>
		<input type="text" name="memberAddr2" size="30" 
			placeholder="상세주소" value="${memberDto.memberAddr2}"><br><br>
		등급 <select>
		<option value="member_level">일반</option>
		<option value="member_level">VIP</option>
		<option value="member_level">관리자</option>
		</select>

	<button>정보변경</button>
 
 </form>
 
 <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
 