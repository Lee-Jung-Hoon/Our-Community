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
    padding-left: 10px;
	border-bottom: 1px solid #5A5A5A;
    padding: 15px 0;
    white-space: normal;
}

.bitcampdiv table th {
	text-align:center;
	color : white;
	border-bottom: 1px solid #5A5A5A;
    padding: 15px 0;
    white-space: normal;
    background: #1F1F1F;
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
</style>

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
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
	<h1>오늘의 맛집 추천</h1>
	<hr/>
	<div class="layerWrap">
	<form action="/OurCommunity/menu/regist" method="post">
		<table align="center">
			<tr>
				<th>제목</th>
				<td colspan="3"><input type="text" name="title" size="148" /></td>
			</tr>
			<tr>
				<th>메뉴정보</th>
				<td colspan="3"><textarea rows="30" cols="150" name="content"></textarea></td>
			</tr>
			<tr>
				<th>위치설정</th>
				<td colspan="3"><input type="hidden" id="latitude" name="latitude" /> <input
					type="hidden" id="longitude" name="longitude" /> <input
					type="hidden" id="restaurantName" name="restaurantName" /> 
					
					 <button type="button" class="btn btn-default btn-sm" onclick="doMap()">
         				 <span class="glyphicon glyphicon-map-marker"></span> 위치 검색/설정
        			</button>
					
					<div id="map" style="width: 500px; height: 400px;"></div></td>
			</tr>
			<tr>
				<td colspan="3" align="right"><button type="submit" class="btn btn-default btn-sm">
								<span class="glyphicon glyphicon-floppy-disk"></span> 등록
							</button>
				</td>
			</tr>
		</table>
	</form>
	</div></div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>