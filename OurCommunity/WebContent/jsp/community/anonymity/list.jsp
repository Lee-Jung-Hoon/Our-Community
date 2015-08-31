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
	<h1>게시글 목록</h1>
	<hr />
	<table style="width: 80%" border="1">
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th><th>등록일</th>
	</tr>
	<c:forEach var="list" items="${list}" >
	<tr>
		<td >${list.no}</td>
		<td>${list.title}</td>
		<td>${list.id}</td>
		<td>${list.regDate}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="4"><a href="/OurCommunity/Anonymity/writeform">게시글 등록</a></td>
	</tr>
	</table>
</body>
</html>