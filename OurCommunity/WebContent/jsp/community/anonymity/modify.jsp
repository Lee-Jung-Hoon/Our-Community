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

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding: 6px 10px;
	border: 1px solid #1f1f1f;
	overflow: hidden;
	background: #373737;
	border: 1px solid #1f1f1f;
}

.bitcampdiv table th {
color : white;
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
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

.layerWrap {
	position: relative;
	width: 1400px;
	margin: 100px auto 50px;
	overflow: hidden;
	background: #2d2d2d;
	padding: 40px 40px;
}

.idDIV {
	color: white;
}

</style>
</head>
<body>
		<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>수정</h1>
		<hr />
		<div class="layerWrap">
			<form action="/OurCommunity/Anonymity/modify" method="POST">
				<table align="center">
					<tr>
						<th>작성자</th>
						<td class="idDIV"><input type="hidden" value="${modify.no}" name="no" />
							${modify.id}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="148"
							value="${modify.title}" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea cols="150" rows="30" name="content">${modify.content}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3" align="right">
							<button type="submit" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-floppy-disk"></span> 수정 등록
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>