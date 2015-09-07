<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
	font-size: 15px;
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
		<h1>학습 게시판</h1>
		<hr />
		<div class="layerWrap">
			<c:if test="${!empty userId}">
				<button type="button" class="btn btn-default btn-sm"
					onclick="location.href='/OurCommunity/jsp/community/studyFile/write.jsp'">
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
				<p />
			</c:if>
			<div class="search_box">
				<form action="/OurCommunity/studyFile/list" method="get">
					검색 구분 <select name="searchlist">
						<option value="no">번호</option>
						<option value="type">말머리</option>
						<option value="title">제목</option>
					</select> <input type="text" name="content" />
					<button type="submit" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-search"></span> 검색
					</button>
				</form>
			</div>
			<p />
			<table border="1" id="listtable" align="center" class="">
				<tr>
					<th align="center" width="100px">글번호</th>
					<th align="center" width="200px">글머리</th>
					<th align="center" width="500px">제목</th>
					<th align="center" width="200px">작성일</th>
					<th align="center" width="200px">작성자</th>
					<th align="center" width="100px">조회수</th>
				</tr>
				<c:forEach var="sList" items="${list}">
					<tr>
						<td align="center" width="100px">${sList.no}</td>
						<td align="center" width="200px">${sList.type}</td>
						<td align="center" width="500px"><a
							href="/OurCommunity/studyFile/detail?no=${sList.no}&id=${sList.id}">${sList.title}</a></td>
						<td align="center" width="200px">${sList.regDate}</td>
						<td align="center" width="200px">${sList.id}</td>
						<td align="center" width="100px">${sList.checkCnt}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
			<div align="center" class="pagingDIV">
				<c:forEach var="index" begin="1" end="${pagingSize}">
					<a
						href="/OurCommunity/studyFile/list?pagenum=${index}&searchlist=${search}&content=${content}">[${index}]</a>
				</c:forEach>
			</div>
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>