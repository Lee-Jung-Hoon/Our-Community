<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�Խ���</title>
</head>

<body>
	<h1>Bitcamp Board</h1>
	<hr />
	
<!-- 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
		<a href="/Community/ourclassboard/list"><button>���</button></a> 
	<form action="/Community/ourclassboard/write" method="post">
		<table border="1" align="center">
					<tr>
						<th><select name="boardhead">
								<option value="����">����</option>
								<option value="����">����</option>
								<option value="����2">����2</option>
						</select></th>
					</tr>

					<tr>
						<th align="center">TITLE</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>

					<tr>
						<th align="center">ID</th>
						<td><input name="id" size="50" maxlength="50"></td>
					</tr>

					<tr>
						<th align="center">CONTENT</th>
						<td><textarea name="content" cols="150" rows="12" placeholder="�̰��� ������ �Է��ϼ���"></textarea></td>
					</tr>

					<tr align="center">
						<td colspan="2"><input type="submit" value="�۵��">
							<input type=reset value="���ۼ�"></td>


					</tr>
				</table>
		</form>
		
		
</body>
</html>