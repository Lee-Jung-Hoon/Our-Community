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
	color: white;
	padding: 6px 10px;
	border: 1px solid #1f1f1f;
	overflow: hidden;
	text-align: center;
	background: #373737;
}

.bitcampdiv table th {
	color: white;
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
		<h1 align="center">회원 활동내역 게시판</h1>
		<hr />
		<div class="layerWrap">
			<p />

			<table align="center">
				<p />
				<tr>
					<th width="300px">이름</th>
					<th width="620px">아이디</th>
					<th width="300px">가입일</th>
				</tr>
				<c:forEach var="list" items="${list}">
					<tr>
						<td align="center" width="300px">${list.name}</td>
						<td align="center" width="620px"><a href="/OurCommunity/mypage/detailMemberHistory?id=${list.id}">${list.id}</a>
						<td align="center" width="300px">${list.joinDate}</td>
					</tr>
				</c:forEach>
			</table>
			<hr />
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>