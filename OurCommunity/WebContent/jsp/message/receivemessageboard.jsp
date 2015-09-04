<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

body {
	color: white;
	background-image: url("http://www.gphotography.ch/v1/assets/templates/Version2009/BG.jpg");
	
}

</style>
<title>Insert title here</title>
</head>
<body>
		<h1>받은 메시지함</h1>
		<small>받은 메시지 목록을 보여드립니다.</small>
		<hr />
			<input type="button" value="메시지 보내기"
				onclick="location.href='/OurCommunity/jsp/message/messagesend.jsp'" />
			<p />
		
		<table border="1" id="listtable" align="center">
			<tr>
				<th align="center" width="500px">제목</th>
				<th align="center" width="200px">받은 일자</th>
				<th align="center" width="200px">보낸 사람</th>
				<th align="center" width="200px">읽음 여부</th>
			</tr>
			<c:forEach var="list" items="${list}">
			<tr>
				<td align="center" width="500px"><a href='/OurCommunity/message/receivedetailmessage?no=${list.no}'>${list.title}</a></td>
				<td align="center" width="200px">${list.sendDate}</td>
				<td align="center" width="200px">${list.id}</td>
				<td align="center" width="200px">${list.read}</td>
			</tr>
			</c:forEach>
		</table>
</body>
</html>