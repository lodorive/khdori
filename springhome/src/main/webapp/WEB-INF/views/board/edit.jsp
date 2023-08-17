<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>수정페이지</h2>
<form action="edit" method="post" autocomplete="off">
	<input type="hidden" name="boardNo" value="${boardDto.boardNo}">
	제목 <textarea name="boardTitle"  rows="1" cols="60">${boardDto.boardTitle}</textarea> <br><br>
	내용 <textarea name="boardContent"   rows="10" cols="60">${boardDto.boardContent}</textarea><br><br>
	<button>게시글 수정</button>
	</form>
	<h2><a href="list">돌아가기</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>