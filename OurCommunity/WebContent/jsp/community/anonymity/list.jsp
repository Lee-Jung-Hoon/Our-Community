<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><%@ include file="/jsp/include/topMenu.jsp"%>
	<h1 align="center">익명 게시판</h1>
	<hr />
	<table style="width: 80%" border="1" align="center">
	<tr>
			<td colspan="4"><a href="/OurCommunity/Anonymity/writeform"><button>글등록</button></a></td>
	</tr>
	<tr>
		<th>번호</th><th>제목</th><th>등록일</th><th>조회수</th>
	</tr>
	<c:forEach var="list" items="${board}" >
	<tr>
		<td align="center" width="10%">${list.no}</td>
		<td align="center" width="60%"><a href="/OurCommunity/Anonymity/detail?no=${list.no}">${list.title}</a></td>
		<td align="center" width="20%">${list.regDate}</td>
		<td align="center" width="10%">${list.checkCnt}</td>
	</tr>
	</c:forEach>
	</table>
	<form action="/OurCommunity/Anonymity/search" method="POST">
	<table style="width: 80%" border="1" align="center">
	<tr align="center">
		<td colspan="3">
			<select name="searchType" >
				<option value="title" >제목</option>
				<option value="content" >내용</option>
			</select>
			<input type="text" name="text" />
			<input type="submit" value="검색"/>
		</td>
	</tr>
	</table>
	</form>
</body>
</html>