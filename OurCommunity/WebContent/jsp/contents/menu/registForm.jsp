<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=f0040f951e55ee311e570465605bc234&libraries=services"></script>
<script>
	function doMap() {
		var container = document.getElementById('map');
		var options = {
			center : new daum.maps.LatLng(33.450701, 126.570667),
			level : 3
		//지도 확대
		};

		//지도 생성
		var map = new daum.maps.Map(container, options);

		//장소 검색 객체 생성
		var ps = new daum.maps.services.Places();
		ps.keywordSearch(prompt("입력"), placesSearchCB);

		//키워드 검색 완료 시 호출
		function placesSearchCB(status, data, pagination) {
			if (status == daum.maps.services.Status.OK) {
				var bounds = new daum.maps.LatLngBounds();

				for (var i = 0; i < data.places.length; i++) {
					displayMarker(data.places[i]);
					bounds.extend(new daum.maps.LatLng(data.places[i].latitude,
							data.places[i].longitude));
				}

				// 지도 범위설정
				map.setBounds(bounds);
			}
		}

		function displayMarker(place) {

			// 마커 생성
			var marker = new daum.maps.Marker(
					{
						map : map,
						position : new daum.maps.LatLng(place.latitude,
								place.longitude)
					});

			// 마커에 클릭이벤트를 등록
			daum.maps.event.addListener(marker, 'click', function() {
				if (confirm(place.title + "로 위치를 지정하겠습니까?")) {
					container = document.getElementById('map');
					options = {
						center : new daum.maps.LatLng(place.latitude,
								place.longitude),
						level : 3
					};

					var map = new daum.maps.Map(container, options);
					var marker = new daum.maps.Marker({
						map : map,
						position : new daum.maps.LatLng(place.latitude,
								place.longitude)
					});
					var latitude = document.getElementById("latitude");
					latitude.value = place.latitude;
					var longitude = document.getElementById("longitude");
					longitude.value = place.longitude;
					var restaurantName = document
							.getElementById("restaurantName");
					restaurantName.value = place.title;
				}
			});

		}
	}
</script>
</head>
<body>
	<form action="/OurCommunity/menu/regist" method="post">
		<table border="1" align="center">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" size=70 /></td>
			</tr>
			<tr>
				<th>메뉴정보</th>
				<td><textarea rows="6" cols="72" name="content"></textarea></td>
			</tr>
			<tr>
				<th>위치설정</th>
				<td><input type="hidden" id="latitude" name="latitude" /> <input
					type="hidden" id="longitude" name="longitude" /> <input
					type="hidden" id="restaurantName" name="restaurantName" /> <a
					href="#" onclick="doMap();">지도등록</a>
					<div id="map" style="width: 500px; height: 400px;"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="등록" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>