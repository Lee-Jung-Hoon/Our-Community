<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int paging = (int) request.getAttribute("paging");
	String search = (String) request.getAttribute("search");
	String searchCategory = (String) request.getAttribute("searchCategory");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <style type="text/css">

body {
	color: white;
	background-image: url("http://www.gphotography.ch/v1/assets/templates/Version2009/BG.jpg");
	
}
</style> 
-->
<title>Insert title here</title>


</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1>자바 73 게시판</h1>
	<hr />
	<c:if test="${!empty userId}">
		<a href="/OurCommunity/jsp/notice/ourclassboard/writeForm.jsp"><button>글등록</button></a>
	</c:if>
	<a href="/OurCommunity/ourclassboard/list"><button>목록</button></a>
	<table width="70%" cellspacing="2" border="2" align="center">
		<tr>
			<td align="center" width="10%">NO</td>
			<td align="center" width="10%">BOARDHEAD</td>
			<td align="center" width="30%">TITLE</td>
			<td align="center" width="20%">ID</td>
			<td align="center" width="20%">REG_DATE</td>
			<td align="center" width="10%">COUNT</td>
		</tr>

		<c:forEach var="list" items="${list}">
			<tr>
				<td align="center">${list.no}</td>
				<td align="center">${list.boardhead}</td>
				<td align="center"><a
					href="/OurCommunity/ourclassboard/detail?no=${list.no}">${list.title}</a></td>
				<td align="center">${list.id}</td>
				<td align="center">${list.regDate}</td>
				<td align="center">${list.checkCnt}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="pagingDIV" align="center">
		<%
				for (int i = 1; i <= paging; i++) {
			%>
		<a
			href="/OurCommunity/ourclassboard/list?pageNum=<%=i%>&search=<%=search%>&searchCategory=<%=searchCategory%>">[<%=i%>]
		</a>
		<%
				}
			%><p />
	</div>


	<form action="/OurCommunity/ourclassboard/list">
		<table align="center">
			<tr>
				<td align="center"><select name="searchCategory">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="search"> 
				<input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>


</body>
</html>