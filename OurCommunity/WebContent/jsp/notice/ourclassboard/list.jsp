<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int paging = (int) request.getAttribute("paging");
	String search = (String) request.getAttribute("search");
	String searchCategory = (String) request.getAttribute("searchCategory");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background: url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
	font-size:15px;
	color : white;
}
	
table {
	color : white;
}

table a {
	color: white;
}

.bitcampdiv table {
    border-top: 5px solid #cd5d31;
}

a {
	color: white;	
	text-decoration : none;
}

.bitcampdiv table td {
	color : white;
    padding: 6px 10px;
    border: 0.5px solid #1f1f1f;
    overflow: hidden;
    text-align: center;
    background: #373737;
}

.bitcampdiv table th {
	color : white;
	text-align : center;
    padding: 13px 10px;
    background: #1f1f1f;
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

.pagingDIV a{
	color: white;
	font-size: 20px;
}

table {
	width: 100%;
	height: 100%;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
	<h1>자바 73 게시판</h1>
	<hr />
	
	<div class="layerWrap">
	<c:if test="${!empty userId}">
		<a href="/OurCommunity/jsp/notice/ourclassboard/writeForm.jsp"><button>글등록</button></a>
	</c:if>
	<a href="/OurCommunity/ourclassboard/list"><button>목록</button></a><p>
	<table align="center">
		<tr>
			<th align="center" width="10%">NO</th>
			<th align="center" width="10%">BOARDHEAD</th>
			<th align="center" width="30%">TITLE</th>
			<th align="center" width="20%">ID</th>
			<th align="center" width="20%">REG_DATE</th>
			<th align="center" width="10%">COUNT</th>
		</tr>

		<c:forEach var="list" items="${list}">
			<tr>
				<td align="center">${list.no}</td>
				<td align="center">${list.boardhead}</td>
				<td align="center"><a
					href="/OurCommunity/ourclassboard/detail?no=${list.no}">${list.title}</a></td>
				<td align="center">${list.id}</td>
				<td align="center">${list.regDate}</td>
				<td align="center">${list.checkCnt}</td>
			</tr>
		</c:forEach>
	</table>

	<div class="pagingDIV" align="center">
		<%
				for (int i = 1; i <= paging; i++) {
			%>
		<a
			href="/OurCommunity/ourclassboard/list?pageNum=<%=i%>&search=<%=search%>&searchCategory=<%=searchCategory%>">[<%=i%>]
		</a>
		<%
				}
			%><p />
	</div>


	<form action="/OurCommunity/ourclassboard/list">
		<table align="center">
			<tr>
				<td align="center"><select name="searchCategory">
						<option value="title">제목</option>
						<option value="content">내용</option>
				</select> <input type="text" name="search"> 
				<input type="submit" value="검색"></td>
			</tr>
		</table>
	</form>
	</div>
	</div>

</body>
</html>