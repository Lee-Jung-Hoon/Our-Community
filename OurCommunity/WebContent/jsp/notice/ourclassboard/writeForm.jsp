<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
</head>

<body>
<%@ include file="/jsp/include/topMenu.jsp" %>
	<h1>Bitcamp Board</h1>
	<hr />
	
	<a href="/OurCommunity/ourclassboard/list"><button>목록</button></a> 
	<form action="/OurCommunity/ourclassboard/write" method="post">
		<table border="1" align="center">
					<tr>
						<th><select name="boardhead">
								<option value="공지">공지</option>
								<option value="자유">자유</option>
								<option value="자유2">자유2</option>
						</select></th>
					</tr>

					<tr>
						<th align="center">TITLE</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>

					<tr>
						<th align="center">CONTENT</th>
						<td><textarea name="content" cols="150" rows="12" placeholder="이곳에 내용을 입력하세요"></textarea></td>
					</tr>

					<tr align="center">
						<td colspan="2"><input type="submit" value="글등록">
							<input type=reset value="재작성"></td>


					</tr>
				</table>
		</form>
		
		
</body>
</html>