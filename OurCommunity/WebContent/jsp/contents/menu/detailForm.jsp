<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	padding: 6px 10px;
	border: 0.5px solid silver;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
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

table {
	width: 100%;
}
</style>

<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=f0040f951e55ee311e570465605bc234&libraries=services"></script>
</head>

<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
			<h1>맛집 게시판</h1>
			<hr />
		<div class="layerWrap">
				<a href="/OurCommunity/jsp/contents/menu/registForm.jsp">등록</a> <a
					href="/OurCommunity/mod?num=${menu.num}">수정</a> <a
					href="/OurCommunity/menu/delete?num=${menu.num}">삭제</a>
				<table align="center">
					<tr>
						<th>장소</th>
						<td colspan="4">${menu.restaurantName}</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="4">${menu.title}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td colspan="4">${menu.regDate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td colspan="4">${menu.id}</td>
					</tr>
					<tr>
						<th>내용 및 위치</th>
						<td >
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
							<p>
							${menu.content}
						</td>
					</tr>
				</table>
				<hr />
				<h1 align="center">댓글</h1>
				<table style="width: 50%" border="1" align="center">
					<tr>
						<th>댓글</th>
						<th>내용</th>
						<th>등록일</th>
					</tr>
					<c:forEach var="comment" items="${list}">
						<tr>
							<td align="center" width="15%">${comment.id}</td>
							<td align="center" width="55%">${comment.menuComment}</td>
							<td align="center" width="25%">${comment.commentDate}</td>
							<td width="5"><a
								href="/OurCommunity/comment/delete?no=${comment.no}&num=${menu.num}">X</a></td>
						</tr>
					</c:forEach>
				</table>
				<form action="/OurCommunity/comment/regist" method="post">
					<table style="height: 500;" align="center">

						<tr>
							<td><input type="text" size="15" name="id" /></td>
							<td colspan="3"><input type="text" size="80" name="content" /></td>
							<td align="right"><input type="submit" value="등록"> <input
								type="hidden" name="num" value="${menu.num}" /></td>
						</tr>
					</table>
				</form>
			</div>
			<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>