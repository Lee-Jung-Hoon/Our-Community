<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	text-align: center; padding : 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid #2d2d2d;
	padding: 13px 10px;
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
.sendtype{ 
color: black; 
 } 
</style>
</head>
<body>
	<div class="bitcampdiv">
		<h1>메세지 작성</h1>
		<hr />
		<form action="/OurCommunity/message/MessageSendController"
			method="post">
			<table style="height: 200;">

				<tr>
					<th>제목</th>
					<td class=sendtype colspan="3"><input type="text" size="50" name="title" /></td>
				</tr>
				<th>받는 이</th>
				<td colspan="3"><input type="text" size="30" name="sendId" class=sendtype />
					<input type="checkbox" /> 강사님에게</td>
				<tr>

				</tr>

				<tr>
					<th>메세지 내용</th>
					<td colspan="3"><textarea class=sendtype cols="50" rows="15" name="content"></textarea>
					</td>
				</tr>

				<tr></tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-pencil"></span> 글등록
						</button>
						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/jsp/message/messagemain.jsp'"/>
						<span class="glyphicon glyphicon-remove"></span> 취소
						</button> 
					</td>
			</table>
		</form>
	</div>
</body>
</html>