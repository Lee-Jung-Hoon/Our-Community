<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#dday {
	background-color: gray;
	color: white;
	font-weight: bold;
}

a {
	text-decoration: none;
}
</style>
<script type="text/javascript">
	function dday(y, m, d) {
		today = new Date();
		dday = new Date(y, m - 1, d);
		n = Math.floor((dday.getTime() - today.getTime()) / 86400000) + 1;

		document.write("D-" + n);
	}
</script>

<div>
	<table>
		<tr>
			<td id="dday"><script>
				dday(2015, 12, 09);
			</script></td>
			<td align="right" width="1700px"><c:choose>
					<c:when test="${empty userId}">
						<a href="/OurCommunity/jsp/memberjoin.html">Join Us | </a>
						<a href="/OurCommunity/jsp/login.jsp">Login</a>
					</c:when>
					<c:otherwise>
						<a href="/OurCommunity/jsp/main/index.html">Home | </a>
						<a href="/OurCommunity/jsp/login.jsp">마이페이지 | </a>
						<a href="/OurCommunity/join/LogoutController">로그아웃</a>
					</c:otherwise>
				</c:choose></td>
		</tr>
	</table>
</div>
