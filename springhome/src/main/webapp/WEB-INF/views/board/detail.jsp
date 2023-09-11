<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-800">
	<div class="row">
		<h1>
			${boardDto.boardNo}번 게시글
			<c:if test="${boardDto.boardUtime != null}">
				(수정됨)
			</c:if>
		</h1>
	</div>
	<div class="row left">
		<h3>
			<i class="fa-solid fa-user"></i>
			${boardDto.boardWriterString}
			<%-- 탈퇴한 사용자가 아닐 경우 닉네임을 옆에 추가로 출력 --%>
			<c:if test="${writerDto != null}">
			(${writerDto.memberNickname})
			</c:if>
		</h3>
	</div>
	<div class="row right">
				<fmt:formatDate value="${boardDto.boardCtime}" pattern="y년 M월 d일 E a h시 m분 s초"/>
	</div>
	<div class="row right">
		<i class="fa-solid fa-eye"></i> 
		${boardDto.boardReadcount}
		&nbsp;&nbsp;
		<i class="fa-solid fa-heart red"></i> 
		${boardDto.boardLikecount}
		&nbsp;&nbsp;
		<i class="fa-solid fa-comment blue"></i> 
		${boardDto.boardReplycount}
	</div>
	<div class="row left">
		<h2>${boardDto.boardTitle}</h2>
	</div>
	
	<%-- 게시글 내용(본문) --%>
	<div class="row left" style="min-height:250px">
		<pre>${boardDto.boardContent}</pre>
	</div>
	
	<%-- 댓글과 관련된 화면이 작성될 위치 --%>
	<div class="row left">
	<form>
		<div class="row">
		<textarea name="" class="form-input w-100" rows="4"></textarea>
		</div>
		<div class="row">
		<button class="btn btn-positive w-100">
		<i class="fa-solid fa-pen"></i>
		등록</button>
		</div>
	</form>
	</div>
	
	<div class="row left w-600">
		<div class="row flex-container">
			<div class="w-75">
				<div class="row left">
					<h3 class="DB이름">작성자</h3>
				</div>
				<div class="row left">
					<pre class="DB이름">내용</pre>
				</div>
				<div class="row left">
					<span class="DB이름">yyyy-MM-dd HH:mm:ss</span>
				</div>
			</div>
			<div class="w-25">
				<div class="row right">
					<button class="btn">
						<i class="fa-solid fa-edit"></i>
					</button>
				</div>
				<div class="row right">
					<button class="btn btn-negative">
						<i class="fa-solid fa-trash"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	
	<%-- 각종 버튼이 위치하는 곳 --%>
	<div class="row right">
		<%-- 회원일 때만 글쓰기,수정,삭제가 나와야 한다 --%>
		<c:if test="${sessionScope.name != null}">
		<a class="btn btn-positive" href="write">
			<i class="fa-solid fa-pen"></i>
			새글
		</a>
		<a class="btn btn-positive" href="write?boardParent=${boardDto.boardNo}">
			<i class="fa-solid fa-comment"></i>
			답글
		</a>
		
		<%-- 수정/삭제는 소유자일 경우만 나와야 한다 --%>
		<c:if test="${sessionScope.name == boardDto.boardWriter}">
		<a class="btn btn-negative" href="edit?boardNo=${boardDto.boardNo}">
			<i class="fa-solid fa-pen-to-square"></i>
			수정
		</a>
		<a class="btn btn-negative" href="delete?boardNo=${boardDto.boardNo}">
			<i class="fa-solid fa-trash"></i>
			삭제
		</a>
		</c:if>
		</c:if>
		<a class="btn" href="list">
			<i class="fa-solid fa-list"></i>
			목록
		</a>
	</div>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>