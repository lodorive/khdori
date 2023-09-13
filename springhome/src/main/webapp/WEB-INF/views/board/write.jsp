<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- summernote cdn -->
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<style>
        .note-editable {
            line-height: 2 !important;
        }
    </style>

<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

<script src="/js/boardWrite.js"></script>
<script>
<!-- javascript 작성 공간 -->
    $(function () {
        $('[name=boardContent]').summernote({
            placeholder: '내용을 작성하세요',
            tabsize: 2, //탭을 누르면 이동할 간격
            height: 250, //에디터 높이
            minHeight: 250, //에디터 최소높이
            lineHeight:20, //기본 줄간격(px)
            toolbar: [
                ['style', ['style']],
                ['font', ['bold', 'underline', 'italic']],
                ['color', ['color']],
                ['para', ['paragraph']],
                ['table', ['table']],
                ['insert', ['link']],
            ]
        });
    });
</script>

<form action="write" method="post" autocomplete="off" onsubmit="return checkForm();">
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
					<input type="text" name="boardTitle" class="form-input w-100" onblur="checkBoardTitle();"
									value="RE: ${originDto.boardTitle}">
					<div class="fail-feedback">제목은 필수이며 100자 이내로 작성하세요</div>
				</c:when>
				<c:otherwise>
					<input type="text" name="boardTitle" class="form-input w-100" onblur="checkBoardTitle();">
					<div class="fail-feedback">제목은 필수이며 100자 이내로 작성하세요</div>
				</c:otherwise>
			</c:choose>
        </div>
        
        <div class="row left">
            <label>내용</label>
            <textarea name="boardContent" class="form-input w-100" style="min-height:250px" oninput="checkBoardContent();"></textarea>
            <div class="fail-feedback">내용은 반드시 작성해야 합니다</div>
        </div>
        <div class="row right">
            <span class="len">0</span> / 1000
        </div>
        <div class="row right">
            <button type="submit" class="btn btn-positive">
            <i class="fa-solid fa-plus"></i>
            작성하기</button>
            <a href="list" class="btn">목록보기</a>
        </div>
    </div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>