<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int paging = (int) request.getAttribute("paging");
	String search = (String) request.getAttribute("search");
	String searchCategory = (String) request.getAttribute("searchCategory");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

body {
	color: white;
	background-image: url("http://www.gphotography.ch/v1/assets/templates/Version2009/BG.jpg");
	
}

</style>
<title>Insert title here</title>
</head>
<body>
	<div class="bitcampdiv">
		<%@ include file="/jsp/include/topMenu.jsp"%>
		<h1>비트캠프 공지사항</h1>
		<small>해당 게시판은 비트캠프의 공지사항을 게시하는 공지사항 게시판입니다.</small>
		<hr />
		<c:if test="${grade eq '운영자'}">
			<input type="button" value="글쓰기"
				onclick="location.href='/OurCommunity/jsp/notice/bitcampboard/registnoticebitcampboard.jsp'" />
			<p />
		</c:if>
		<table border="1" id="listtable" align="center">
			<tr>
				<th align="center" width="100px">글번호</th>
				<th align="center" width="200px">글머리</th>
				<th align="center" width="500px">제목</th>
				<th align="center" width="200px">작성일</th>
				<th align="center" width="200px">작성자</th>
				<th align="center" width="100px">조회수</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td align="center" width="100px">${list.no}</td>
					<td align="center" width="200px">${list.boardHead}</td>
					<td align="center" width="500px"><a
						href='/OurCommunity/bitcampboard/NoticeBitcampDetailBoardController?no=${list.no}'>${list.title}</a></td>
					<td align="center" width="200px">${list.regDate}</td>
					<td align="center" width="200px">${list.id}</td>
					<td align="center" width="100px">${list.checkCnt}</td>
				</tr>
			</c:forEach>
		</table>
		<hr />
			<%
				for (int i = 1; i <= paging; i++) {
			%>
			<a
				href="/OurCommunity/bitcampboard/NoticeBitcampListBoardController?pageNum=<%=i%>&search=<%=search%>&searchCategory=<%=searchCategory%>">[<%=i%>]
			</a>
			<%
				}
			%><p />
			
		<form action="/OurCommunity/bitcampboard/NoticeBitcampListBoardController" method="get">
			<select name="searchCategory">
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">작성자</option>
			</select> <input type="text" name="search"> <input type="submit"
				value="검색">
		</form>
	</div>
</body>
</html>