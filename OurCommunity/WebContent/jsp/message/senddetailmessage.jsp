<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>보낸 메시지</h1>
	<hr/>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${message.title}</td>
		</tr>
		
		<tr>
			<th>받은 이</th>
			<td>${message.sendId}</td>
		</tr>
		
		<tr>
			<th>보낸 날짜</th>
			<td>${message.sendDate}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${message.content}</td>
		</tr>
		
	</table>
</body>
</html>