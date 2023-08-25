<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${isReply}">
	<h3>답글 작성</h3>
	</c:when>
	<c:otherwise>
	  <div class="container w-600">
        <div class="row">
            <h2>게시글 작성</h2>
        </div>
	</c:otherwise>
</c:choose>	

<form action="write" method="post" autocomplete="off">
<%-- 답글일 때만 추가 정보를 전송--%> 
	<c:if test="${isReply}">
	<input type="hidden" name="boardParent" value="${originDto.boardNo}">
	</c:if>

	<c:choose>
	<c:when test="${isReply}">
		 <div class="row left">
            <label>제목</label>
            <input type="text" name="boardTitle" class="form-input w-100">
        </div>
	</c:when>
	<c:otherwise>
		 <div class="row left">
            <label>제목</label>
            <input type="text" name="boardTitle" class="form-input w-100">
        </div>
	</c:otherwise>
</c:choose>	
		<div class="row left">
            <label>내용</label>
            <textarea name="boardContent" class="form-input fixed w-100"></textarea>
        </div>
		<div class="row right">
            <button class="btn btn-positive">글쓰기</button>
            <a href="list" class="btn">목록</a></div>      
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>