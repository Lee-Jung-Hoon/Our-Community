<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="KO">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title></title>
<script src="http://www.imbc.com/commons/libs/jquery-1.11.1.min.js"></script>
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

.a {
	color: white;
	padding-left: 10;
	font-size: 40px;
	color: white;
	font-weight: bold;
	display: block;
	height: 100%;
	overflow: hidden;
	}

.layerInner section:nth-child(1) {
	float: left;
	width: 403px;
	height: 200px;
	background: gray;
	margin-right: 3px;
}

.layerInner section:nth-child(2) {
	float: left;
	width: 403px;
	height: 403px;
	background: gray;
}

.layerInner section:nth-child(3) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	top: 0;
	right: 0;
}
.layerInner section:nth-child(3) a {
	text-align:center;
	line-height:200px;
} 
.layerInner section:nth-child(3) img {
	vertical-align:middle;
}

.layerInner section:nth-child(4) {
	width: 200px;
	height: 403px;
	background: gray;
	position: absolute;
	bottom: 0;
	left: 0;
}

.layerInner section:nth-child(5) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 203px;
	left: 203px;
}
.layerInner section:nth-child(5) a {
	text-align:center;
	line-height:200px;
} 
.layerInner section:nth-child(5) img {
	vertical-align:middle;
}

.layerInner section:nth-child(6) {
	width: 403px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 0;
	left: 203px;
}

.layerInner section:nth-child(7) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 0;
	right: 203px;
}

.layerInner section:nth-child(8) {
	width: 200px;
	height: 200px;
	background: gray;
	position: absolute;
	bottom: 203px;
	right: 0;
}
.layerInner section:nth-child(9) {
	width: 200px;
	height: 200px;
	position: absolute;
	bottom: 0;
	right: 0;
	background:gray;
}
.dday {
	color: white;
	padding-left: 10;
	font-size: 40px;
	color: white;
	font-weight: bold;
}
.noticeATag {
	display: block
}


html {
	background-color: black;
}
</style>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});

	google.setOnLoadCallback(drawChart);

	function drawChart() {
		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Topping');
		data.addColumn('number', 'Slices');

		<c:forEach var="item" items="${ilist}">
		data.addRows([ [ "${item.subsection}", Number("${item.count}") ] ]);
		</c:forEach>

		var options = {
			'title' : document.getElementById("title").innerHTML,
			'width' : 200,
			'height' : 200
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
</head>
<body>
	<%@include file="/jsp/include/topMenu.jsp"%>
	<div class="layerWrap">
		<div class="layerInner">
			<section>
			<p align="center" class="dday">
				<script>
					function dday(y, m, d) {
						today = new Date();
						dday = new Date(y, m - 1, d);
						n = Math
								.floor((dday.getTime() - today.getTime()) / 86400000) + 1;
						document.write("D-" + n);
					}
					dday(2015, 12, 09);
				</script>
			</p>
			</section>
			<section></section>
			<section><a  class="a" href="/OurCommunity/gallery/list">
			<img style="width: 150px; height: 150px;" src="/OurCommunity/image/photoImage.png">
			</a></section>
			<section>학습자료실?</section>
			<section>
				<c:choose>
					<c:when test="${empty id}">
						<a class="a" href="/OurCommunity/jsp/login.jsp"> 
							<img style="width: 100px; height: 100px;"
							src="/OurCommunity/image/loginImage.png">
						</a>
					</c:when>
					<c:otherwise>
						<a class="a" href="/OurCommunity/join/LogoutController">
							<img style="width: 100px; height: 100px;"
							src="/OurCommunity/image/logoutImage.png">
						</a>
					</c:otherwise>
				</c:choose>
			</section>
			<section>
					<span class="dday">NOTICE</span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="/OurCommunity/bitcampboard/NoticeBitcampListBoardController" class="dday">+</a>
					<c:forEach var="i" items="${noticeList}">
						<a href="/OurCommunity/bitcampboard/NoticeBitcampDetailBoardController?no=${i.no}" class="noticeATag">[공지]${i.title}</a>
					</c:forEach>
			</section>
			<section id="chart_div">
				<p id="title">${voteList.v_title}</p>
			</section>
			<section><a class="a" href="/OurCommunity/workInfo/list">취업정보</a></section>
			<section>회원가입</section>
		</div>
	</div>
	<%@include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>
