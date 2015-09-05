<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function dday(y, m, d) {
		today = new Date();
		dday = new Date(y, m - 1, d);
		n = Math.floor((dday.getTime() - today.getTime()) / 86400000) + 1;

		document.write("D-" + n);
	}

	function Message() {
		window.open('/OurCommunity/jsp/message/messagemain.jsp', '쪽지',
						'width=380, height=300,scrollbars=no, menubar=no, status=no, toolbar=no');
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
			<td align="left" width="40%" class="dday"><script>
				dday(2015, 12, 09);
			</script></td>
			<td align="right" width="60%" class="menu"><c:choose>
					<c:when test="${empty userId}">
						<input type="button" value="Join Us"
							onclick="location.href='/OurCommunity/jsp/memberjoin.html'">
						<input type="button" value="Login"
							onclick="location.href='/OurCommunity/jsp/login.jsp'">
					</c:when>
					<c:otherwise>
						<input type="button" value="Home"
							onclick="location.href='/OurCommunity/jsp/main/index.html'">
						<input type="button" value="MyPage"
							onclick="location.href='/OurCommunity/jsp/login.jsp'">
						<input type="button" value="Message" onclick='Message();'>
						<input type="button" value="LogOut"
							onclick="location.href='/OurCommunity/join/LogoutController'">
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</div>

