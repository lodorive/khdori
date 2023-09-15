<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
  <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
  
  <div class="container w-200">
  <div class="row">
  <h1>가라! ${pocketmonDto.name}!</h1>
  </div>
  <div class="row">
  <h4>번호 = ${pocketmonDto.no}</h4>
  <h4>이름 = ${pocketmonDto.name}</h4>
  <h4>속성 = ${pocketmonDto.type}</h4>
  
  <c:choose>
  	<c:when test="${pocketmonDto.image}">
 		 <img src="image?no=${pocketmonDto.no}" width="200" height="200">
  	</c:when>
  	<c:otherwise>
  		<img src="https://dummyimage.com/200x200/000/fff" width="200" height="200">
 	 </c:otherwise>
  </c:choose>
  </div>
  </div>
    
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
