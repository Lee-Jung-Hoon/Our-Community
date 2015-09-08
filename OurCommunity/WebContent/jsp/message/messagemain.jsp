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
</head>
<body>	
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
.bitcampdiv li {
	border-top: 5px solid #cd5d31;
}

.sendDiv{
	border-bottom: 5px solid #cd5d31;
	align: center;
	font-size: 40px;
}

.div1 {
	position: relative;
	overflow: hidden;
	padding: 40px 40px;
	background: #2d2d2d;
	align: center;
	font-size: 15px;
	color: black;
	font-style: " AppleGothic"
}


</style>
</head>
	<p class="sendDiv">메시지</p>
	<ol class="div1">
	
		<li><input type="button" value="메시지 보내기" onclick="location.href='/OurCommunity/jsp/message/messagesend.jsp'"></li><br />
		<li><input type="button" value="받은 메시지함" onclick="location.href='/OurCommunity/message/receivelist'"></li><br />
		<li><input type="button" value="보낸 메시지함" onclick="location.href='/OurCommunity/message/sendmessagelist'"></li>
		
	</ol>

</body>
</html>