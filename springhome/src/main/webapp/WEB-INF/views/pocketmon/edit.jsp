<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
     
  <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
  
  <form action="edit" method="post" enctype="multipart/form-data">
  
  	<div class="container w-400">
	<div class="row">
	<h2>포켓몬스터 수정</h2>
	</div>
  	<input type="hidden" name="no" value="${pocketmonDto.no}"><br><br>
  	이름 : <input type="text" name="name" class="form-input w-100" value="${pocketmonDto.name}"><br><br>
  	속성 : <input type="text" name="type"  class="form-input w-100"value="${pocketmonDto.type}"><br><br>
  	
  	<!-- input[type=file]은 절대로 vlaue를 설정할 수 없다(보안상의 이유) -->
  	<div class="form-input w-100">
  	<input type="file" name="attach">
  	<c:if test="${pocketmonDto.image}">
  		<img src="image?no=${pocketmonDto.no}" width="100" height="100">
  	</c:if>
  	</div>
  	
  	<br><br>
  	
  	<button type="submit" class="btn btn-positive w-100">수정하기</button>
  	
  </div>
  </form>
  
   <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>