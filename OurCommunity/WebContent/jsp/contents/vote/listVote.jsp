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
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1>투표 게시판</h1>
	<small>해당 게시판은 비트캠프 자바 73기의 투표 게시판입니다.</small>
	<hr />
	<input type="button" value="글쓰기"
				onclick="location.href='/OurCommunity/jsp/contents/vote/registVoteForm.jsp'" />
			<p />
	<table align="center" border="1">
		<tr>
			<th align="center" width="100px">글번호</th>
			<th align="center" width="500px">제목</th>
			<th align="center" width="200px">작성일</th>
			<th align="center" width="200px">작성자</th>
			<th align="center" width="100px">조회수</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr align="center">
				<td>${list.v_no}</td>
				<td><a href="/OurCommunity/vote/detailVote?v_no=${list.v_no}">${list.v_title}</a></td>
				<td>${list.start_date}</td>
				<td>${list.id}</td>
				<td>${list.v_clicks}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>