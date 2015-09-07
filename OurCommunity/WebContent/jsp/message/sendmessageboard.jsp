<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	color: white;
	background-image:
		url("http://www.gphotography.ch/v1/assets/templates/Version2009/BG.jpg");
}

html {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
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
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid #2d2d2d;
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

table {
	width: 100%;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="bitcampdiv">
		<h1>보낸 메시지함</h1>
		<hr />
		<input type="button" value="메시지 보내기"
			onclick="location.href='/OurCommunity/jsp/message/messagesend.jsp'" />
		<input type="button" value="목록"
			onclick="location.href='/OurCommunity/jsp/message/messagemain.jsp'" />
		<p />

		<table border="1" id="listtable" align="center">
			<tr>
				<th align="center" width="400px">제목</th>
				<th align="center" width="200px">받은 일자</th>
				<th align="center" width="200px">받은 사람</th>
				<th align="center" width="200px">읽음 여부</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td align="center" width="400px"><a
						href='/OurCommunity/message/senddetailmessage?no=${list.no}'>${list.title}</a></td>
					<td align="center" width="200px">${list.sendDate}</td>
					<td align="center" width="200px">${list.sendId}</td>
					<td align="center" width="200px">${list.read}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>