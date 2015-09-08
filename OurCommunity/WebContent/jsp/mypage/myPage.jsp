<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	font-size: 15px;
	color: white;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
	color: white;
}

table {
	width: 100%;
	height: 100%
}

html, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

li {
	list-style: none;
}

img {
	border: 0 none;
	vertical-align: top;
}

table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

legend, caption {
	visibility: hidden;
	width: 0;
	height: 0;
	line-height: 0;
	font-size: 0;
	color: transparent;
}

.layerWrap {
	position: relative;
	width: 1012px;
	height: 300px;
	margin: 100px auto 50px;
	overflow: hidden;
}

.layerWrap {
	background: black;
}

.layerInner {
	width: 110%;
	padding-bottom: 30;
}

.layerInner section:nth-child(1) {
	float: left;
	width: 491px;
	height: 300px;
	background: black;
	margin-right: 30px;
	border: white solid 1px;
}

.layerInner section:nth-child(1) a {
	text-align: center;
	line-height: 200px;
}

.layerInner section:nth-child(2) {
	float: left;
	width: 491px;
	height: 300px;
	background: black;
	border: white solid 1px;
}

.layerInner section:nth-child(2) a {
	text-align: center;
	line-height: 300px;
	color: white;
	font-size: 45px;
	margin-left: 110px
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="layerWrap">

		<div class="layerInner">

			<section>
			<table width="491" height="300" border="1px">
				<tr>
					<a href="/OurCommunity/mypage/detailMemberHistory">내가 쓴 글</a>
				</tr>
			</table>
			</section>

			<section> <a href="/OurCommunity/mypage/personalInfo">
				개인정보수정</a> </section>

			<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>

