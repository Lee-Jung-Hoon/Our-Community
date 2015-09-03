<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body><%@ include file="/jsp/include/topMenu.jsp"%>
	<h1 align="center">글 작성</h1>
	<hr />
	<br />
	<form action="/OurCommunity/gallery/regist" method="post" enctype="multipart/form-data">
		<table style="height: 500;" align="center">
			<tr>
				<th>글쓴이</th>
				<td><input type="text" size="30" name="id"/></td>

			</tr>

			<tr>
			
				<th>제목</th>
				<td colspan="3"><input type="text" size="148" name="title" /></td>
			</tr>

			<tr>
				<th>&nbsp;&nbsp;&nbsp;업로드 사진&nbsp;&nbsp;&nbsp;</th>
				<td><input type="file" name="userfile" /></td>
			</tr>

			<tr>
				<th>글 내용</th>
				<td colspan="3"><textarea wrap="virtual" cols="150" rows="30"
						name="content"></textarea></td>
			</tr>

			<tr>
				<th>공개 설정</th>
				<td colspan="3" align="center"><input type="radio" name="scope"
					value="0" checked="checked" /> 전체공개 <input type="radio"
					name="scope" value="1" /> 멤버공개
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td align="right"><input type="submit" value="등록"></td>
		</table>
	</form>
</body>
</html>