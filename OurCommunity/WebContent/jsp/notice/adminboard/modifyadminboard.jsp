<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
html {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
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
	padding-left: 10px;
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
}

.bitcampdiv table th {
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
	background: #1F1F1F;
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
</style>

</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1 align="center">비트캠프 공지사항 수정</h1>
	<hr />
	<br />
	<div class="layerWrap">
		<div class="bitcampdiv">
			<form
				action="/OurCommunity/adminboard/NoticeAdminModifyUpdateBoardController"
				method="post">
				<table style="height: 500;" align="center">
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" size="148" name="title"
							value="${board.title}" /></td>
					</tr>

					<tr>
						<th>글 내용</th>
						<td colspan="3"><textarea cols="150" rows="30" name="content"">${board.content}</textarea>
						</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><input type="hidden" value="${no}" name="no"></td>
						<td align="right"><input type="submit" value="수정 등록" /></td>
						</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>