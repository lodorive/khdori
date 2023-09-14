<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
  <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
  

  <div class="container w-400 center">
  <div class="row">
  <h2>포켓몬스터 목록</h2>
  </div>
  <c:forEach var="pocketmonDto" items="${list}">
  	<div>
  		${pocketmonDto.no} / ${pocketmonDto.name} / ${pocketmonDto.type}
  		 <c:choose>
  			<c:when test="${pocketmonDto.image}">
 		 		<img src="image?no=${pocketmonDto.no}" width="50" height="50">
  			</c:when>
  		<c:otherwise>
  				<img src="https://dummyimage.com/50x50/000/fff">
 	 	</c:otherwise>
  			</c:choose>
  	</div>
  	<hr>
  </c:forEach>
  </div>
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
