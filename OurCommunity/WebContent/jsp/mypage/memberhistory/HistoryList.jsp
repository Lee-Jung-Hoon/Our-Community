<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<c:import url="/jsp/include/bootstrap.jsp" />
<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
	color: white;
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
}

table {
	color: white;
}

table a {
	color: white;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding: 6px 10px;
	border: 0.5px solid #1f1f1f;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
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

.commentDIV {
	color: black;
}
</style>
<style>
table {
	width: 100%;
	height: 100%;
}

comm_text {
	color: black;
}
</style>

</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">${id}님의 활동내역</h1>
		<hr />
		<div class="layerWrap">
			<p />

			<table align="center">
				<p />
				<tr>
					<th width="300px">아이디</th>
					<th width="300px">게시판</th>
					<th width="620px">제목</th>
					<th width="300px">등록일</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td align="center" width="300px">${list.id}</td>
						<td align="center" width="300px">${list.board}</td>
						<td align="center" width="620px">${list.title}</td>
						<td align="center" width="300px">${list.regDate}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>