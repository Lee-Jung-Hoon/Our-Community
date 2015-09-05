<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	border: 1px solid #1f1f1f;
	overflow: hidden;
	text-align: center;
	background: #373737;
}

.bitcampdiv table th {
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
</style>

</head>
<body>
<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
	<h1>상세목록</h1>
	<hr />
	
	<div class="layerWrap">
	<table align="center">
	<tr>
		<td colspan="4">
			<a href="/OurCommunity/Anonymity/list">목록</a>
			<c:if test="${userId eq anonymity.id}">
			<a href="/OurCommunity/Anonymity/modifyForm?no=${anonymity.no}">수정</a>
			<a href="/OurCommunity/Anonymity/delete?no=${anonymity.no}">삭제</a>
			</c:if>
		</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td >${anonymity.checkCnt}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${anonymity.title}</td>
	</tr>
	<tr>
		<th>등록시간</th>
		<td>${anonymity.regDate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${anonymity.content}</td>
	</tr>
	</table>
		<br /><br />
	<table align="center">
	<tr>
		<th >댓글러</th><th>내용</th><th>등록일</th>
	</tr>
	<c:forEach var="comment" items="${comment}" >
	<tr>
		<td align="center" width="15%">${comment.id}</td>
		<td align="center" width="55%">${comment.content}</td>
		<td align="center" width="25%">${comment.regDate}</td>
		<c:if test="${userId eq comment.id}" >
		<td width="5"><a href="/OurCommunity/Anonymity/Cdelete?no=${anonymity.no}&comment_no=${comment.commentNo}">삭제</a></td>
		</c:if>
	</tr>
	</c:forEach>
	<c:if test="${empty comment}">
		<td colspan="3">등록된 댓글이 없습니다.</td>
	</c:if>
	</table>
	<br /><br />
	<form action="/OurCommunity/Anonymity/comment" method="POST">
      <table style="height: 500;" align="center">

			<tr>
				<td colspan="3">
					<h3 align="center">댓글 등록</h3> 
					<input type="hidden" name="no" value="${anonymity.no}" />
				</td>
			</tr>
			<tr>
            <td colspan="3"><input type="text" size="80" name="content" /></td>
            <td align="right"><input type="submit" value="등록" ></td>
         </tr>
      </table>
	</form>
	</div></div>

</body>
</html>