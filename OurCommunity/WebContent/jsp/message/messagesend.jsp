<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메세지 작성</h1>
	<hr />
	<form action="/OurCommunity/message/MessageSendController"
		method="post">
		<table style="height: 200;" >

			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" size="40" name="title" /></td>
			</tr>
				<th>받는 이</th>
				<td colspan="3">
					<input type="text" size="20" name="sendId" />
					<input type="checkbox" /> 강사님에게
				</td>
			<tr>
				
			</tr>

			<tr>
				<th>메세지 내용</th>
				<td colspan="3"><textarea cols="40" rows="10" name="content"></textarea>
				</td>
			</tr>

			<tr></tr>	
			<tr>
				<td></td>
				<td align="center"><input style="width: 100px" type="submit" value="등록" />
				<input style="width: 100px" type="button" value="취소" />
				</td>
		</table>
	</form>

</body>
</html>