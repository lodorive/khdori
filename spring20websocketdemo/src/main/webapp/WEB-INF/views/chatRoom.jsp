<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>채팅리스트</h1>
	<c:forEach var="chatRoomDto" items="${list}">
			${chatRoomDto.chatRoomNo}
			${chatRoomDto.clubNo}
			${chatRoomDto.chatRoomName}
			<br>
	</c:forEach>

</body>
</html>