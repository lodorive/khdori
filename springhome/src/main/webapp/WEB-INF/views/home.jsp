<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 매번 페이지 코드를 복사할 수 없으니 미리 만든 것을 불러오도록 설정 
		- 템블릿 페이지(template page)라고 부름
		- 절대경로를 사용할 것
--%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="center">		
<h2>NewJeans!</h2>	<br>
<img src="https://cdn-icons-png.flaticon.com/512/13/13950.png" width="14" height="14">Hype Boy - NewJeans<br><br>
<img src="https://img.vogue.co.kr/vogue/2022/07/style_62da53d70fb28-600x428.jpeg" width="600" height="400"><br><br><br>
<img src="https://cdn-icons-png.flaticon.com/512/13/13950.png" width="14" height="14">Super Shy - NewJeans<br><br>
<img src="https://img.gqkorea.co.kr/gq/2023/08/style_64cb1badf3c78-1400x934.jpg" width="600" height="400"><br><br><br>
<img src="https://cdn-icons-png.flaticon.com/512/13/13950.png" width="14" height="14">Attention - NewJeans<br><br>
<img src="https://cdn.eyesmag.com/content/uploads/posts/2022/09/28/main-newjeans-reality-show-busan-a56fab74-64c6-40f7-a9c3-c4150dc25ada.jpg" width="600" height="400">
</div>			

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>