<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<c:import url="/jsp/include/bootstrap.jsp" />
<style>
table a {
	color: white;
}

body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

.bitcampdiv table {
	border-top: 2px solid #cd5d31;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	color : white;
	padding: 6px 10px;
	border: 1px solid #1f1f1f;
	overflow: hidden;
	text-align: center;
	background: #373737;
}

.bitcampdiv table th {
	color : white;
	text-align: center;
	padding: 13px 10px;
	background: #1f1f1f;
	border: 1px solid #2d2d2d;
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

.SearchBtn {
	border: 0px;
	font-size: 0px;
	width: 78px;
	height: 28px;
	vertical-align: middle;
	border: 1px solid #48556e;
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

<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">

		<h1 align="center">익명 게시판</h1>
		<hr />
		<div class="layerWrap">
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/Anonymity/writeform'">
				<span class="glyphicon glyphicon-pencil"></span> 글등록
			</button>
			<p />

			<div class="search_box">
				<form action="/OurCommunity/Anonymity/list" method="GET">
					검색 구분  <select name="searchType">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select> <input type="text" name="text" /> <input type="submit" value="검색" />
				</form>
			</div>
			<table border="1" align="center">

				<p />
				<tr>
					<th align="center">번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="list" items="${board}">
					<tr>
						<td align="center" width="100px">${list.no}</td>
						<td align="center" width="820px"><a
							href="/OurCommunity/Anonymity/detail?no=${list.no}">${list.title}</a></td>
						<td align="center" width="200px">${list.regDate}</td>
						<td align="center" width="200px">${list.checkCnt}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<div class="pagingDIV" align="center">
				<c:forEach var="i" begin="1" end="${page}">
					<a
						href="/OurCommunity/Anonymity/list?page=${i}&searchType=${type}&text=${text}">[${i}]</a>
				</c:forEach>
			</div>
		</div>

		<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>