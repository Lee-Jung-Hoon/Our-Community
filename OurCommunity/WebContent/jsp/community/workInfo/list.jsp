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
	<h1>일이닷정보</h1>
				<hr>
				<table border="1">
				<tr>
					<th>컴퍼니 이름</th><th>공고진행여</th><th>제목</th><th>게시일</th><th>마감일</th>
				</tr>
				<%-- DB Table --%>
			<c:forEach var="info" items="${workInfoList}">
			<tr>
				<td>${info.company}</td>
				<td>${info.active}</td>
				<td>${info.title}</td >
				<td>${info.postingTimeStamp}</td>
				<td>${info.expirationTimeStamp}</td>
			</tr>
		</c:forEach>
	
</body>
</html>