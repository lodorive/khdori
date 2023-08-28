<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="write" method="post" autocomplete="off">
	<%-- 답글일 때만 추가 정보를 전송 --%>
	<c:if test="${isReply}">
	<input type="hidden" name="boardParent" value="${originDto.boardNo}">
	</c:if>
	
	<div class="container w-600">
        <div class="row">
            <c:choose>
	            <c:when test="${isReply}">
					<h1>답글 작성</h1>
				</c:when>
				<c:otherwise>
					<h1>게시글 작성</h1>
				</c:otherwise>
            </c:choose>
        </div>
        <div class="row left">
            <label>제목</label>
            
            <c:choose>
				<c:when test="${isReply}">
					<input type="text" name="boardTitle" class="form-input w-100"
									value="RE: ${originDto.boardTitle}">
				</c:when>
				<c:otherwise>
					<input type="text" name="boardTitle" class="form-input w-100">
				</c:otherwise>
			</c:choose>
        </div>
        
        <div class="row left">
            <label>내용</label>
            <textarea name="boardContent" class="form-input w-100" style="min-height:250px"></textarea>
        </div>
        <div class="row right">
            <button type="submit" class="btn btn-positive">글쓰기</button>
            <a href="list" class="btn">목록보기</a>
        </div>
    </div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>