<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h3>자유 게시판</h3>
	<h5 style="color:red">타인에 대한 비방은 경고 없이 삭제됩니다</h5>
	
<%-- 검색일 경우 검색어를 추가로 출력 --%>	
<%-- <c:if test="${param.keyword != null}"> --%>
<c:if test="${isSearch}">
<h5>&quot;${param.keyword}&quot;에 대한 검색 결과</h5>
</c:if>	
	<%--글쓰기는 로그인 상태인 경우에만 출력--%>
	<c:if test="${sessionScope.name != null}">
	<h4><a href="write">글쓰기</a></h4>
	</c:if>
	<table border="1" width="800">
		<thead>
			<tr>
				<th>번호</th>
				<th width="40%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>그룹</th>
				<th>상위</th>
				<th>차수</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="boardListDto" items="${list}">
			<tr>
				<td>${boardListDto.boardNo}</td>
				<td align="left">
					
					<%-- for(int i=1; i<=차수; i++ --%>
					<c:forEach var="i" begin="1" end="${boardListDto.boardDepth}" step="1">
					&nbsp;&nbsp;
					</c:forEach>
					
					<%-- 띄어쓰기 뒤에 화살표 표시 --%>
					<c:if test="${boardListDto.boardDepth > 0}">
<!-- 						<img src="https://littledeep.com/wp-content/uploads/2020/09/arrow-icon-style.png" width="20" height="20"> -->
						<img src="/images/icon.png" width="20" height="20">
					</c:if>
					
					<a href="detail?boardNo=${boardListDto.boardNo}">
					${boardListDto.boardTitle}
					</a>
					
					<!-- 댓글이 있다면 개수를 표시 -->
					<c:if test="${boardListDto.boardReplycount >0 }">
					[${boardListDto.boardReplycount}]
					</c:if>
				</td>
				
				<%-- 사용자가 없으면 탈퇴한 사용자로 표시 
					(방법1)
					<c:choose>
					<c:when test="${boardDto.boardWriter != null}">
						<td>${boardDto.boardWriter}</td>					
					</c:when>
					<c:otherwise>
						<td>(탈퇴한 사용자)</td>
					</c:otherwise>
				</c:choose>
				
				--%>
				<td>${boardListDto.boardWriterString}</td> <%--(방법2) 메소드로 사용 시 --%>
				
				<td>${boardListDto.boardCtimeString}</td>
				<td>${boardListDto.boardReadcount}</td>
				<td>${boardListDto.boardLikecount}</td>
				<td>${boardListDto.boardGroup}</td>
				<td>${boardListDto.boardParent}</td>
				<td>${boardListDto.boardDepth}</td>
			</tr>
			</c:forEach>
		</tbody>

	</table><br>
	
	<!-- 검색창 -->
	<form action="list" method="get">
		<c:choose>
			<c:when test="${param.type == 'board_writer'}">
				<select name="type" required="required">
				<option value="board_title">제목</option>
				<option value="board_writer" selected>작성자</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="type" required="required">
				<option value="board_title">제목</option>
				<option value="board_writer">작성자</option>
		</select>
			</c:otherwise>
		</c:choose>
	
		
		<input type="search" name="keyword" placeholder="검색어"  value="${param.keyword}"
				required="required" autocomplete="off">
		<button>검색</button>
	</form><br>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>