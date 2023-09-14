<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="insert" method="post" enctype="multipart/form-data" autocomplete="off">
	<div class="container w-400">
	<div class="row">
	<h2>포켓몬스터 등록</h2>
	</div>
	이름 : <input type="text" name="name" class="form-input w-100"><br><br>
	속성 : <input type="text" name="type" class="form-input w-100"><br><br>
	
	<!-- 이미지 : <input type="file" name="attach" accept=".png, .jpg, .gif"><br><br> -->
	이미지 : <input type="file" name="attach" accept="image/*" class="form-input w-100"><br><br>
	
	<button type="submit" class="btn btn-positive w-100">등록</button>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>