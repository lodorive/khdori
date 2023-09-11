<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!--  댓글과 관련된 처리를 할 수 있도록 jQuery 코드 구현 -->
<script>
$(function(){
	//목표 : 댓글등록을 누르면 입력정보로 ajax 통신을 통해 댓글 등록 처리
	//(주의) form은 전송이 되면 안된다
	
	$(".reply-insert-form").submit(function(e){
		//this == e.target == 폼(form)
		
		//입력검사 코드(skip)
		
		//기본이벤트 차단
		e.preventDefault();
		
		//비동기 통신 발생
		$.ajax({
			//url:"http://localhost:8080/rest/reply/insert",
			url:"/rest/reply/insert",
			method:"post",
			//data:{ replyOrigin : ? , replyContent : ? },
			data : $(e.target).serialize(),
			success:function(response){
				//console.log("성공");
				$("[name=replyContent]").val("");
			}
		});
	});
	
	//목록은 페이지가 로딩되면 바로 불러오도록 구현한다.
	//- 등록이 완료된 경우 불러오도록 구현한다.
	//- 여러 곳에서 사용할 수 있도록 함수 형태로 구현한다.
	//- 목록을 모두 지우고 전부 다 새로 불러오도록 구현한다.
	loadList();
	
	function loadList(){
		//화면 청소
		$(".reply-list").empty(); //자기 자신을 제외한 내부 코드 삭제
		
		//Javascript로 boardNo라는 이름의 파라미터 값 읽기
		var params = new URLSearchParams(location.search); //분석해..
		var no = params.get("boardNo"); 
		
		//비동기 통신으로 화면 갱신
		$.ajax({
			url:"/rest/reply/list",
			method:"post",
			data:{replyOrigin : no},
			success:function(response){
				//response는 댓글 목록(JSON)
				console.log(response);
			},
		})
	}
	
});
</script>

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
	<form  class="reply-insert-form">
		<input type="hidden" name="replyOrigin" value="${boardDto.boardNo}">
		
		<div class="row">
			<textarea name="replyContent" class="form-input w-100" rows="4"></textarea>
		</div>
		<div class="row">
			<button class="btn btn-positive w-100">
			<i class="fa-solid fa-pen"></i>
			등록
			</button>
		</div>
	</form>
	</div>
	
	<%-- 댓글 목록이 표시될 영역 --%>
	<div class="row left reply-list">
	
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