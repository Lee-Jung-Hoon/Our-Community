<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1>반 게시판</h1>
	<hr />
	<form action="/OurCommunity/ourclassboard/modifyUpdate" method="get">
		<td><input type="hidden" value="${board.no}" name="no"></td>
		<table align="center" border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" value="${board.title}" name="title"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" value="${board.id}" name="id"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="12" cols="150" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="수정"></td>
			</tr>
		</table>
	</form>
</body>
</html>