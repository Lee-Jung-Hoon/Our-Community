<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table border="1" align="center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
			</tr>
			
			<c:forEach var="menu" items="${list}">
				<tr>
					<td>${menu.num}</td>
					<td><a href="/OurCommunity/menu/detail?num=${menu.num}">${menu.title}</a></td>
					<td>${menu.id}</td>
					<td>${menu.regDate}</td>
					<td>${menu.count}</td>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="5" align="right"><a
					href="/OurCommunity/jsp/contents/menu/registForm.jsp">글쓰기</a></td>
			</tr>
		</table>
	</form>
	<table align="center">
		<tr>
			<c:forEach var="i" begin="1" end="${pageLeng}">
				<td>
					<a href="/OurCommunity/menu/list?pageNum=${i}&type=${type}&search=${search}">[${i}]</a>
				</td>
			</c:forEach>
		</tr>
	</table>
	<form action="/OurCommunity/menu/list">
		<select name = "type">
			<option value="id">작성자</option>
			<option value="content">내용</option>
			<option value="title">제목</option>
			<option value="restaurant_name">장소</option>
		</select>
		<input type="text" name="search" />
		<input type="submit" value="검색" />
	</form>
</body>
</html>