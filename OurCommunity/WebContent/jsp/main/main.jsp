<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="KO">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title></title>
<script src="http://www.imbc.com/commons/libs/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function dday(y, m, d) {
	today = new Date();
	dday = new Date(y, m - 1, d);
	n = Math.floor((dday.getTime() - today.getTime()) / 86400000) + 1;

	document.write("D-" + n);
}
</script>
<!--[if lt IE 9]><script src="http://www.imbc.com/commons/libs/html5shiv.min.js"></script><![endif]-->
<style type="text/css">
/* reset start */
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

article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section, main {
	display: block;
}

a {
	text-decoration: none;
}

button {
	background: none;
	border: 0;
	cursor: pointer;
}

.blind, .hide {
	position: absolute;
	left: 0;
	top: 0;
	visibility: hidden;
	width: 0;
	height: 0;
	line-height: 0;
	font-size: 0;
	color: transparent;
}
/* reset end */
.layerWrap {
	position: relative;
	width: 1012px;
	height: 606px;
	margin: 100px auto 50px;
	overflow: hidden;
}
.layerWrap {
    background: #2d2d2d;
}

.layerInner {
	width: 110%;
	padding-bottom: 30;
}

.layerInner div:nth-child(1) {
	float: left;
	width: 403px;
	height: 200px;
	background: gray;
	margin-right: 3px;
}

.layerInner div:nth-child(2) {
	float: left;
	width: 403px;
	height: 403px;
	background: gray;
}

.layerInner div:nth-child(3) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	top: 0;
	right: 0;
}

.layerInner div:nth-child(4) {
	width: 200px;
	height: 403px;
	background: gray;
	position: absolute;
	bottom: 0;
	left: 0;
}

.layerInner div:nth-child(5) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 203px;
	left: 203px;
}

.layerInner div:nth-child(6) {
	width: 403px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 0;
	left: 203px;
}

.layerInner div:nth-child(7) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 0;
	right: 203px;
}

.layerInner div:nth-child(8) {
	width: 200px;
	height: 403px;
	background: gray;
	position: absolute;
	bottom: 0;
	right: 0;
}
.dday {
	color: white;
}

html {
	background-color: black;
}
</style>
</head>
<body>
	<%@include file="/jsp/include/topMenu.jsp"%>
	<div class="layerWrap">
		<div class="layerInner">
			<div><a href=""><div></div></a></div>
			<div><a href=""><div></div></a></div>
			<div>포토</div>
			<div>학습자료실</div>
			<div>로그인</div>
			<div>비트공지</div>
			<div>투표</div>
			<div>취업정보</div>
		</div>
	</div>
	<%@include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>
