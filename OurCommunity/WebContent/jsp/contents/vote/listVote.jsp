<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int paging = (int) request.getAttribute("paging");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>투표 게시판</h1>
		<hr />
		<div class="layerWrap">
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/jsp/contents/vote/registVoteForm.jsp'" />
			<span class="glyphicon glyphicon-pencil"></span> 글등록
			</button>

			<p />
			<table align="center">
				<tr>
					<th align="center" width="200px">글번호</th>
					<th align="center" width="600px">제목</th>
					<th align="center" width="300px">마감일</th>
					<th align="center" width="300px">작성자</th>
					<th align="center" width="200px">조회수</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr align="center">
						<td>${list.v_no}</td>
						<td><a href="/OurCommunity/vote/detailVote?v_no=${list.v_no}">${list.v_title}</a></td>
						<td>${list.end_date}</td>
						<td>${list.id}</td>
						<td>${list.v_clicks}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />

			<div align="center" class="pagingDIV">
				<%
				for (int i = 1; i <= paging; i++) {
			%>
				<a href="/OurCommunity/vote/listVote?pageNum=<%=i%>">[<%=i%>]
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