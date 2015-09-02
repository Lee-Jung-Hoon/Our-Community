<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정</h1>
	<hr />
	<form action="/OurCommunity/Anonymity/modify" method="POST">
	<table align="center" style="width: 50%" border="1">
	<tr>
		<th>작성자</th>
		<td >
		<input type="hidden" value="${modify.no}" name="no" />
		${modify.id}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td ><input type="text" name="title" value="${modify.title}"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="100" rows="20" name="content">${modify.content}</textarea></td>
	</tr>
	<tr>
		<td colspan="3"><input type="submit" value="수정완료" /></td>
	</tr>
	</table>
	</form>
</body>
</html>