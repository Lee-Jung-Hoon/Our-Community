<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=f0040f951e55ee311e570465605bc234&libraries=services"></script>
</head>
<body>
	<form action="/OurCommunity/menu/mod">
		<table border="1" align="center">
			<tr>
				<th>장소 :</th>
				<td colspan="2">${menu.restaurantName}</td>
			</tr>
			<tr>
				<th>Title :</th>
				<td><input type="text" value="${menu.title}" name="title" /></td>
			</tr>
			<tr>
				<td colspan="3"><textarea rows="6" cols="72" name="content">${menu.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="3">
					<div id="map" style="width: 520px; height: 420px;"></div>
					<input
				type="hidden" id="latitude" value="${menu.latitude}" /> <input
				type="hidden" id="longitude" value="${menu.longitude}" /> 
					<script>
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
							var marker = new daum.maps.Marker({
								map : map,
								position : new daum.maps.LatLng(latitude,
										longitude)
							});
						}
					</script>
				</td>
			</tr>
			<tr >
				<td align="center">
					<input type="submit" value="수정" />
					<input type="hidden" name="num" value="${menu.num}" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>