<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>줄/칸 늘리기</title>
	</head>	
	<body>
		
		<h1>테이블 줄/칸 늘리기(셀 병합)</h1>
		<table border="1" width="500">
			<tr>
				<!-- colspan을 주면 오른쪽 방향으로 셀이 늘어난다 -->
				<th colspan="2" width="50%">과목</th>
				<th width="25%">자바</th>
				<th width="25%">오라클</th>
			</tr>
			<tbody align="center">
			<tr>
				<!-- rowspan을 주면 아래 방향으로 셀이 늘어난다 -->
				<th rowspan="2">유형</th>
				<th>문제해결</th>
				<td>70</td>
				<td>80</td>
			</tr>
			<tr>
				<th>체크리스트</th>
				<td>50</td>
				<td>90</td>
			</tr>
			</tbody>
		</table>
		
	</body>
</html>