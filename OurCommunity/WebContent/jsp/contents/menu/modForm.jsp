<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	color: white;
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

<style>
.dday {
	padding-left: 10;
	font-size: 40px;
	color: white;
	font-weight: bold;
}

.menu {
	padding-right: 150;
}

.header {
	width: 100%;
	height: 80px;
	background: #313131;
	color: white;
	text-decoration: none;
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
}

.toptable {
	width: 100%;
	height: 100%;
}
</style>



</head>
<body>




	<script type="text/javascript">
	function dday(y, m, d) {
		today = new Date();
		dday = new Date(y, m - 1, d);
		n = Math.floor((dday.getTime() - today.getTime()) / 86400000) + 1;

		document.write("D-" + n);
	}

	function Message() {
		window.open('/OurCommunity/jsp/message/messagemain.jsp', '쪽지',
						'width=380, height=400,scrollbars=no, menubar=no, status=no, toolbar=no');
	}
</script>
	<style>
.dday {
	padding-left: 10;
	font-size: 40px;
	color: white;
	font-weight: bold;
}

.menu {
	padding-right: 150;
}

.header {
	width: 100%;
	height: 80px;
	background: #313131;
	color: white;
	text-decoration: none;
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
}

.toptable {
	width: 100%;
	height: 100%;
}

.locationDIV {
	color: white;
}

</style>


	<script type="text/javascript"
		src="//apis.daum.net/maps/maps3.js?apikey=f0040f951e55ee311e570465605bc234&libraries=services"></script>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
		<div class="bitcampdiv">
	<h1 align="center">비트캠프 공지사항 수정</h1>
	<hr />
	<br />
	<div class="layerWrap">
			<form action="/OurCommunity/menu/mod">
				<table align="center">
					<tr>
						<th>장소</th>
						<td class="locationDIV" colspan="2">${menu.restaurantName}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" value="${menu.title}" size="148"
							name="title" /></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea rows="30" cols="150" name="content">${menu.content}</textarea></td>
					</tr>
					<tr>
						<th>위치</th>

						<td colspan="3">
							<div id="map" style="width: 520px; height: 420px;"></div> <input
							type="hidden" id="latitude" value="${menu.latitude}" /> <input
							type="hidden" id="longitude" value="${menu.longitude}" /> <script>
								var container = document.getElementById('map');
								var latitude = document
										.getElementById("latitude");
								var longitude = document
										.getElementById("longitude");
								var options = {
									center : new daum.maps.LatLng(
											latitude.value, longitude.value),
									level : 3
								};
								var map = new daum.maps.Map(container, options);
								displayMarker(latitude.value, longitude.value);

								function displayMarker(latitude, longitude) {
									var marker = new daum.maps.Marker({
										map : map,
										position : new daum.maps.LatLng(
												latitude, longitude)
									});
								}
							</script>
						</td>
					</tr>


					<tr>
						<input type="hidden" value="${menu.num}" name="num">
						<td colspan="3" align="right">
							<button type="submit" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-floppy-disk"></span> 수정 등록
							</button>
						</td>
					</tr>
				</table>
		</div>
	</div>
	</form>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>