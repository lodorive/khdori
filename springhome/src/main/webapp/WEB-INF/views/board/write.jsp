<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${isReply}">
	<h3>답글 작성</h3>
	</c:when>
	<c:otherwise>
	<h3>게시글 작성</h3>
	</c:otherwise>
</c:choose>	

<form action="write" method="post" autocomplete="off">
<%-- 답글일 때만 추가 정보를 전송--%> 
	<c:if test="${isReply}">
	<input type="hidden" name="boardParent" value="${originDto.boardNo}">
	</c:if>

	<c:choose>
	<c:when test="${isReply}">
		제목 <textarea name="boardTitle"  rows="1" cols="60"  required="required">RE: ${originDto.boardTitle}</textarea> <br>
	</c:when>
	<c:otherwise>
		제목 <textarea name="boardTitle"  rows="1" cols="60" required="required">${originDto.boardTitle}</textarea> <br>
	</c:otherwise>
</c:choose>	
		내용 <textarea name="boardContent"  rows="10" cols="60" required="required"></textarea> <br><br>
		<button>게시글 등록</button>
	</form>
	
	 		<h2><a href="list">목록으로</a></h2>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>