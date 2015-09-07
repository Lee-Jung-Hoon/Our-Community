<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- <link rel="stylesheet" -->
<!-- 	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->

<c:import url="/jsp/include/bootstrap.jsp" />
<script type="text/javascript">
	function dday(y, m, d) {
		today = new Date();
		dday = new Date(y, m - 1, d);
		n = Math.floor((dday.getTime() - today.getTime()) / 86400000) + 1;

		document.write("D-" + n);
	}

	function Message() {
		window
				.open('/OurCommunity/jsp/message/messagemain.jsp', '쪽지',
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
</style>

<div class="header">
	<table class="toptable">
		<tr>
			<td align="left"><a href="/OurCommunity/main"> <img
					style="width: 305px; height: 70px;"
					src="/OurCommunity/image/box1.png"></a></td>
			<td align="right" width="60%" class="menu"><c:choose>
					<c:when test="${empty userId}">
						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/index.jsp'">
							<span class="glyphicon glyphicon-home"></span> Home
						</button>
						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/jsp/memberjoin.html'">
							<span class="glyphicon glyphicon-user"></span> MyPage
						</button>

						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/jsp/login.jsp'">
							<span class="glyphicon glyphicon-log-in"></span> Login
						</button>

					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/index.jsp'">
							<span class="glyphicon glyphicon-home"></span> Home
						</button>

					
							<button type="button" class="btn btn-default btn-sm"
								onclick="location.href='/OurCommunity/jsp/mypage/myPage.jsp'">
								<span class="glyphicon glyphicon-cog"></span> MyPage
							</button>
						<button type="button" class="btn btn-default btn-sm"
							onclick='Message();'>
							<span class="glyphicon glyphicon-envelope"></span> Message
						</button>

						<button type="button" class="btn btn-default btn-sm"
							onclick="location.href='/OurCommunity/join/LogoutController'">
							<span class="glyphicon glyphicon-log-out"></span> LogOut
						</button>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</div>

