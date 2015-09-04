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
	<h1>자바 73 게시판</h1>
	<hr />
	
	

	<table width="70%" cellpading="1" cellspacing="2" border="2"
		align="center">
		<td><a href="/Community/board/writeForm.jsp"><button>글등록</button></a>
		<a href="/Community/ourclassboard/list"><button>목록</button></a></td>
		</tr>
		<tr>
			<th width="10%">NO</th>
			<th width="10%">BOARDHEAD</th>
			<th width="30%">TiTLE</th>
			<th width="20%">ID</th>
			<th width="20%">REG_DATE</th>
			<th width="10%">COUNT</th>
		</tr>

		<c:forEach var="list" items="${list}">
			<tr>
				<td align="center">${list.no}</td>
				<td align="center">${list.boardhead}</td>
				<td align="center"><a
					href="/Community/ourclassboard/detail?no=${list.no}">${list.title}</a></td>
				<td align="center">${list.id}</td>
				<td align="center">${list.regDate}</td>
				<td align="center">${list.checkCnt}</td>
			</tr>
		</c:forEach>
	</table>
	<form action="/Community/ourclassboard/search">
		<table align="center">
			<tr>
				<td align="center"><select name="searchType">
						<option value="content">content</option>
						<option value="title">title</option>
				</select> <input type="text" name="search"> <input type="submit"
					value="검색"></td>
			</tr>
		</table>
	</form>
	
	<script>
	if ("$(msg)") {
		alert("${msg}");
		}
	</script>

</body>
</html>