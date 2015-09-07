<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
</head>
<body>
	<div class="bitcampdiv">
	<h1>보낸 메시지</h1>
	<hr/>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${message.title}</td>
		</tr>
		
		<tr>
			<th>받은 이</th>
			<td>${message.sendId}</td>
		</tr>
		
		<tr>
			<th>보낸 날짜</th>
			<td>${message.sendDate}</td>
		</tr>
		
		<tr>
			<th>읽음 여부</th>
			<td>${message.read}</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>${message.content}</td>
		</tr>
		
	</table>
	</div>
</body>
</html>