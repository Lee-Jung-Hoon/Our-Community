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
	border: 0.5px solid #1f1f1f;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid #2d2d2d;
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
}

</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
<div class="bitcampdiv">	
<h1 align="center">취업정보</h1>
		<hr />
<div class="layerWrap">
 <table align="center">
 	<tr>
		<td colspan="4">
			<a href="/OurCommunity/workInfo/list"><button>목록</button></a>
			<a href="#" onclick="doDelete()"><button>삭제</button></a>
		</td>
	</tr>
	 <c:set var = "info" value="${info}" />
	 	<tr style="height: 150px">
	 		<td>	&nbsp;- 제목	: ${info.title} <br /><br />
	 		    	&nbsp;- 회사 	: ${info.company} <br /><br />
	 		 	   	&nbsp;- 등록일	: ${info.postingTimeStamp} <br /><br />
	 		     	&nbsp;- 조회수	: ${info.checkCnt} <br />
	 		 </td>
 		</tr>
	</table>
<table align="center">
	<tr>
		<th align="left">▶제목</th>
		<td colspan="4">${info.title}</td>
	</tr>
	<tr>
		<th align="left">▶접수 시작일</th>
		<td>${info.openingTimeStamp}</td>
		<th align="left" >▶접수 마감일</th>
		<td >${info.expirationTimeStamp}</td>
	</tr>
	<tr>
		<th align="left">▶기관명</th>
		<td colspan="4" >${info.company}</td>
	</tr>
	<tr>
		<th align="left">▶링크</th>
		<td  colspan="1"><a href="${info.url}">회사상세정보</a></td>
		<th align="left">▶연봉</th>
		<td colspan="1">${info.salary}</td>
	</tr>
	<tr>
		<th align="left">▶채용직급</th>
		<td  colspan="4">${info.experienceLevel}</td>
	</tr>
	</table></div></div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>