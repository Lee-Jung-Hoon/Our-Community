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
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
	font-size: 15px;
	color: white;
}

table {
	color: white;
}

table a {
	color: white;
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	color: white;
	padding: 6px 10px;
	border: 0.5px solid #1f1f1f;
	overflow: hidden;
	text-align: center;
	background: #373737;
}

.bitcampdiv table th {
	color: white;
	text-align: center;
	padding: 13px 10px;
	background: #1f1f1f;
	border: 0.5px solid #2d2d2d;
}

.bitcampdiv h1 {
	font-size: 55px;
	line-height: 35px;
	height: 41px;
	padding: 42px 0;
	text-align: center;
	color: #fff;
}

.search_box {
	background: #cd5d31;
	padding: 15px 20px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	font-weight: bold;
}

.layerWrap {
	position: relative;
	width: 1400px;
	margin: 100px auto 50px;
	overflow: hidden;
	background: #2d2d2d;
	padding: 40px 40px;
}

.pagingDIV a {
	color: white;
	font-size: 20px;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>운영자 게시판</h1>
		<hr />

		<div class="layerWrap">
				<c:if test="${grade eq '운영자'}">
					<button type="button" class="btn btn-default btn-sm"
						onclick="location.href='/OurCommunity/jsp/notice/adminboard/registnoticeadminboard.jsp'" />
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
				</c:if>
				<p />
			<div class="search_box">
				<form
					action="/OurCommunity/adminboard/NoticeAdminListBoardController"
					method="get">
					검색 구분 <select name="searchCategory">
						<option value="1">제목</option>
						<option value="2">내용</option>
						<option value="3">작성자</option>
					</select> <input type="text" name="search">
					<button type="submit" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-search"></span> 검색
					</button>

				</form>
			</div>
			<table width="100%" id="listtable" align="center" class="">
				<tr>
					<th align="center" width="15%">글번호</th>
					<th align="center" width="30%">제목</th>
					<th align="center" width="20%">작성일</th>
					<th align="center" width="20%">작성자</th>
					<th align="center" width="15%">조회수</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td align="center" width="15%">${list.no}</td>
						<td align="center" width="30%"><a
							href='/OurCommunity/adminboard/NoticeAdminDetailBoardController?no=${list.no}'>${list.title}</a></td>
						<td align="center" width="20%">${list.regDate}</td>
						<td align="center" width="20%">${list.id}</td>
						<td align="center" width="15%">${list.checkCnt}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<div class="pagingDIV" align="center">
				<%
					for (int i = 1; i <= paging; i++) {
				%>
				<a
					href="/OurCommunity/adminboard/NoticeAdminListBoardController?pageNum=<%=i%>&search=<%=search%>&searchCategory=<%=searchCategory%>">[<%=i%>]
				</a>
				<%
					}
				%><p />
			</div>

		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>