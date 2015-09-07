<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<c:import url="/jsp/include/bootstrap.jsp" />
<style type="text/css">
body {
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


<title>Insert title here</title>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">학습게시판 수정</h1>
		<hr />
		<br />
		<div class="layerWrap">
			<form action="/OurCommunity/studyFile/update" method="post"
				enctype="multipart/form-data">
				<table style="height: 500;" align="center">
					<c:set var="updateFile" value="${update}" />
					<tr>

						<th>&nbsp;&nbsp;&nbsp;말머리&nbsp;&nbsp;&nbsp;</th>
						<td class="input1"><select name=searchType>
								<option value="">선택하세요</option>
								<option value="Java">Java</option>
								<option value="Sql">Sql</option>
								<option value="CSS">CSS</option>
								<option value="Script">Script</option>
						</select></td>
						<th>업로드 파일</th>
						<td class="file"><input type="file" name="userfile" /></td>
					</tr>

					<tr>
						<th>제목</th>
						<td class="input2" colspan="3"><input type="text" size="148"
							name="title" value="${updateFile.title}" /></td>
					</tr>

					<tr>
						<th>글 내용</th>
						<td colspan="3" class="input3"><textarea cols="150" rows="30"
								name="content"">${updateFile.content}</textarea></td>
					</tr>

					<tr>
						<th>공개 설정</th>
						<td class="scope" colspan="3" align="center"><input
							type="radio" name="scope" value="전체공개" checked="checked" /> 전체공개
							<input type="radio" name="scope" value="멤버공개" /> 멤버공개 <input
							type="hidden" name="no" value="${update.no}">
					</tr>
					<td align="right" colspan="4">

						<button type="submit" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-floppy-disk"></span> 수정 등록
						</button>
					</td>

				</table>

			</form>
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>