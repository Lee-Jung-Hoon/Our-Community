<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<th>글 번호</th>
			<th>투표제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="list" items="${list}"> 
			<tr>
				<td>${list.v_no}</td>
				<td><a href="/OurCommunity/vote/detailVote?v_no=${list.v_no}">${list.v_title}</a></td> 
				<td>${list.id}</td>
				<td>${list.start_date}</td>
				<td>${list.v_clicks}</td>
			</tr>
		</c:forEach>
							
	</table>
</body>
</html>