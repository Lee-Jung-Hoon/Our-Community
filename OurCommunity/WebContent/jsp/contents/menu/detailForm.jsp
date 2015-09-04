<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=f0040f951e55ee311e570465605bc234&libraries=services"></script>
</head>
<body>
	<a href="/OurCommunity/jsp/contents/menu/registForm.jsp">등록</a>
	<a href="/OurCommunity/mod?num=${menu.num}">수정</a>
	<a href="/OurCommunity/menu/delete?num=${menu.num}">삭제</a>
	<table border="1" align="center">
		<tr>
			<th>장소 :</th>
			<td colspan="2">${menu.restaurantName}</td>
		</tr>
		<tr>
			<th>Title :</th>
			<td>${menu.title}</td>
			<td>${menu.regDate}</td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td colspan="2">${menu.id}</td>
		</tr>
		<tr>
			<td colspan="3" style="height : 150px">${menu.content}</td>
		</tr>
		<tr>
			<td colspan="3">
				<div id="map" style="width: 520px; height: 420px;"></div> <input
				type="hidden" id="latitude" value="${menu.latitude}" /> <input
				type="hidden" id="longitude" value="${menu.longitude}" /> <script>
					var container = document.getElementById('map');
					var latitude = document.getElementById("latitude");
					var longitude = document.getElementById("longitude");
					var options = {
						center : new daum.maps.LatLng(latitude.value,
								longitude.value),
						level : 3
					};
					var map = new daum.maps.Map(container, options);
					displayMarker(latitude.value, longitude.value);

					function displayMarker(latitude, longitude) {
						var marker = new daum.maps.Marker(
								{
									map : map,
									position : new daum.maps.LatLng(latitude,
											longitude)
								});
					}
				</script>
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
</body>
</html>