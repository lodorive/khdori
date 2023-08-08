<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>회원가입</h2>

<form action="join" method="post" autocomplete="off">
		
		아이디* <input type="text" name="memberId" required> <br>
		비밀번호* <input type="password" name="memberPw" required> <br>
		닉네임* <input type="text" name="memberNickname" required> <br>
		이메일 <input type="email" name="memberEmail"> <br>
		연락처 <input type="tel" name="memberContact"> <br>
		생년월일 <input type="date" name="memberBirth"> <br>
		주소<br>
		<input type="text" name="memberPost" placeholder="우편번호" size="6" maxlength="6"> <br>
		<input type="text" name="memberAddr1" placeholder="기본주소"> <br>
		<input type="text" name="memberAddr2" placeholder="상세주소"> <br>
		
		<button>가입하기</button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>