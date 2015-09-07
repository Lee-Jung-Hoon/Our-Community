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
	border: 0.5px solid silver;
	overflow: hidden;
	background: #373737;
	padding: 6px 10px;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
	color: white;
	padding: 13px 10px;
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

.scope {
	color: white;
}

.file {
	color: white;
}
</style>

<style type="text/css">
th {
	width: 200px;
}

/* th, td { */
/* 	border-bottom: 1px solid black; */
/* } */
body {
	font-family: "nanumgothic", '나눔고딕';
}

table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

a {
	color: #888;
	text-decoration: none;
}

.title {
	font-weight: bold;
	font-size: 30px;
}

.date {
	font-size: 13px;
}

.id {
	font-size: 13px;
}

#title {
	font-size: 20px;
	font-weight: bold;
}
.idDIV {
	color: white;
}
.scope {
	color: white;
}

.fileDIV {
	color: white;
}
</style>

</head>
<body>
	<div class="bitcampdiv">
		<%@ include file="/jsp/include/topMenu.jsp"%>
		<h1 align="center">글 수정</h1>
		<hr />
		<br />
		<div class="layerWrap">
			<form action="/OurCommunity/gallery/update" method="post"
				enctype="multipart/form-data">
				<table style="height: 500;" align="center">
					<tr>
						<th>글쓴이</th>
						<td colspan="3" class="idDIV">${vo.id }</td>

					</tr>

					<tr>

						<th>제목</th>
						<td colspan="3"><input type="text" size="148" name="title"
							value="${vo.title }" /></td>
					</tr>

					<tr>
						<th>&nbsp;&nbsp;&nbsp;업로드 사진&nbsp;&nbsp;&nbsp;</th>
						<td colspan="3" class="fileDIV"><input type="file" name="userfile" /></td>
					</tr>

					<tr>
						<th>글 내용</th>
						<td colspan="3"><textarea wrap="virtual" cols="150" rows="30"
								name="content">${vo.content }</textarea></td>
					</tr>

					<tr>
						<th>공개 설정</th>
						<td colspan="3" align="center" class="scope"><input type="radio"
							name="scope" value="0" checked="checked" /> 전체공개 <input
							type="radio" name="scope" value="1" /> 멤버공개
					</tr>

					<tr>
						<td colspan="3" align="right"><input type="hidden" name="no"
							value="${vo.no}">
							<button type="submit" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-floppy-disk"></span> 재등록
							</button>

							<button type="button" class="btn btn-default btn-sm"
								onclick="location.href='/OurCommunity/gallery/detail?no=${vo.no}'">
								<span class="glyphicon glyphicon-trash"></span> 글삭제
							</button></td>
				</table>
			</form>
		</div>
	</div>

</body>
</html>