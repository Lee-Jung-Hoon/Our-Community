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
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
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

table {
	width: 100%;
	height: 100%
}
</style>

<script type="text/javascript"
	src="//apis.daum.net/maps/maps3.js?apikey=50989deb7cd81c1ee38467082c934717&libraries=services"></script>

<script type="text/javascript">
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/OurCommunity/menu/delete?num=${menu.num}";
		}
	}
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
			location.href = '/OurCommunity/mod?num=${menu.num}';
		}
	}
</script>
</head>

<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>맛집 게시판</h1>
		<hr />
		<div class="layerWrap">

			<c:if test="${!empty id}">
				<button type="button" class="btn btn-default btn-sm"
					onclick="location.href='/OurCommunity/jsp/contents/menu/registForm.jsp'">
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
			</c:if>
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/menu/list'">
				<span class="glyphicon glyphicon-list-alt"></span> 목록
			</button>
			<c:if test="${id eq menu.id}">
				<button type="button" class="btn btn-default btn-sm"
					onclick="doModify();">
					<span class="glyphicon glyphicon-edit"></span> 수정
				</button>
				<button type="button" class="btn btn-default btn-sm"
					onclick="doDelete();">
					<span class="glyphicon glyphicon-trash"></span> 글 삭제
				</button>
			</c:if>


			<p>
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
					<td>
						<div id="map" style="width: 520px; height: 420px;"></div> <input
						type="hidden" id="latitude" value="${menu.latitude}" /> <input
						type="hidden" id="longitude" value="${menu.longitude}" /> <script>
							var container = document.getElementById('map');
							var latitude = document.getElementById("latitude");
							var longitude = document
									.getElementById("longitude");
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
						<p>${menu.content}
					</td>
				</tr>
			</table>
			<p>
			<table>
				<c:forEach var="comment" items="${list}">
					<tr>
						<th width="10%">${comment.id}</th>
						<td width="1100px">${comment.menuComment}</td>
						<td width="200px">${comment.commentDate}</td>
						<c:if test="${id eq comment.id}">
							<td width="5"><a
								href="/OurCommunity/comment/delete?no=${comment.no}&num=${menu.num}">삭제</a></td>
						</c:if>
					</tr>
				</c:forEach>
				<c:if test="${!empty id}">
					<form action="/OurCommunity/comment/regist" method="post">
						<input type="hidden" size="15" name="id" value="${id}" />
						<tr>
							<th>댓글</th>
							<input type="hidden" value="${board.no}" name="no" />
							<td colspan="2"><input type='text' size='178px'
								style='height: 100px' name="content" placeholder="댓글을 입력하세요." /></td>
							<td><input type="submit" value="작성" size='350px'
								style='height: 100px' /></td>
							<input type="hidden" name="num" value="${menu.num}" />
							</td>
						</tr>
					</form>
				</c:if>
			</table>


		</div>
		<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>