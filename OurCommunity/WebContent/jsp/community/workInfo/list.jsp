<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<c:import url="/jsp/include/bootstrap.jsp" />
<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	font-size: 15px;
	
	background:	url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
}

table {
	
	color : white;
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
}

table a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	text-align:center;
	padding: 6px 10px;
	border: 0.5px solid silver;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	text-align: center; padding : 13px 10px;
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

.pagingDIV a{
	color: white;
	font-size: 20px;
}
</style>

<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">취업정보 게시판</h1>
		<hr />
		<div class="layerWrap">
		
		
		<div class="search_box">
		<form action="/OurCommunity/workInfo/list" method="get">
					<td>검색 구분 <select name="searchlist">
							<option value="no">번호</option>
							<option value="title">제목</option>
							<option value="company">회사이름</option>
					</select> <input type="text" name="content" /> 
					<button type="submit" class="btn btn-default btn-sm">
          			<span class="glyphicon glyphicon-search"></span> 검색
        		</button></td>
		</form>
		</div>
		<p>
		<table border="1" align="center">
			<tr>
				<th width="100px">번호</th>
				<th width="200px">회사이름</th>
				<th width="600px">제목</th>
				<th width="300px">등록일</th>
				<th width="100px">조회수</th>
			</tr>
			<%-- DB Table --%>
			<c:forEach var="wInfo" items="${workInfoList}">
				<tr>
					<td>${wInfo.no}</td>
					<td>${wInfo.company}</td>
					<td><a href="/OurCommunity/workInfo/detail?no=${wInfo.no}">${wInfo.title}</a></td>
					<td>${wInfo.postingTimeStamp}
						(~${wInfo.expirationTimeStamp}까지)</td>
					<td>${wInfo.checkCnt}</td>
				</tr>
			</c:forEach>
		</table>
		<hr/>
		<div class="pagingDIV" style="text-align: center">
			<c:forEach var="index" begin="1" end="${pagingSize}">
				<a
					href="/OurCommunity/workInfo/list?pagenum=${index}&searchlist=${search}&content=${content}">[${index}]</a>
			</c:forEach>
		</div>
		<br />
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>