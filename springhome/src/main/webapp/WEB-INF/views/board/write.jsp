<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h3>게시글 작성</h3>
	
	<form action="write" method="post" autocomplete="off">
		제목 <textarea name="boardTitle"  rows="1" cols="60"></textarea> <br>
		내용 <textarea name="boardContent"  rows="10" cols="60"></textarea> <br><br>
		<button>게시글 등록</button>
	</form>
	 		<h2><a href="list">목록으로</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>