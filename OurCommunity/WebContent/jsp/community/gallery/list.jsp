<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="/jsp/include/bootstrap.jsp" />
<style>
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

.bitcampdiv table {
	border-top: 2px solid #cd5d31;
}

.bitcampdiv {
	width: 100%;
	height: 100%;
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
	text-align: center;
	padding: 13px 10px;
	background: #1f1f1f;
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

.SearchBtn {
	border: 0px;
	font-size: 0px;
	width: 78px;
	height: 28px;
	color: black;
	vertical-align: middle;
	border: 1px solid #48556e;
}

.layerWrap {
	position: relative;
	width: 1400px;
	margin: 100px auto 50px;
	overflow: hidden;
	background: #2d2d2d;
	padding: 40px 40px;
	margin: 100px auto 50px;
}

.pagingDIV a {
	color: white;
	font-size: 20px;
}
</style>



<style type="text/css">
.wrapper {
	width: 902px;
	height: 464px;
	margin: 50px auto 0;
	padding: 20px 16px;
	/* 	border: 1px solid #ddd; */
	box-sizing: border-box;
}

a {
	color: white;
	text-decoration: none;
}

ul {
	color: white;
	width: 110%;
	overflow: hidden;
	padding: 0;
	margin: 0;
	width: 110%;
}

li {
	float: left;
	width: 156px;
	height: 190px;
	padding: 0;
	margin: 0 30px 50px 0;
	list-style: none;
	overflow: hidden;
	border: 1px solid #ddd;
}

li div {
	width: 126px;
	height: 100px;
	line-height: 100px;
	margin: 5px auto;
	border: 1px solid #ddd;
	overflow: hidden;
}

li img {
	width: 100%;
	display: inline-block;
	vertical-align: middle;
}

li p {
	width: 160px;
	margin: 0 auto;
	text-align: center;
	font-size: 10px;
}

.title {
	font-size: 14px;
	font-weight: bold;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.id {
	font-size: 11px
}

.button {
	width: 902px;
	margin: 0px auto 0;
	padding: 20px 16px;
	box-sizing: border-box;
}

div {
	width: 902px;
	margin: 0px auto 0;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">
			<a href="/OurCommunity/gallery/list">Photo Gallery</a>
		</h1>
		<div class="layerWrap">
			<div class="wrapper">
				<div class="search_box" align="left">
					<form action="/OurCommunity/gallery/list">
						검색 구분 <select name="select"><option value="0">제목+내용</option>
							<option value="1">제목</option>
							<option value="2">내용</option>
							<option value="3">아이디</option></select> <input type="text" name="search"
							size="20px" /> <input type="submit" size="20px" />
					</form>
				</div>
				<p>
				<ul>
					<c:forEach var="vo" items="${list}">

						<li>
							<div>
								<a href="/OurCommunity/gallery/detail?no=${vo.no }"><img
									src="${vo.filePath}/${vo.fileName}" width="100%"></a>
							</div>
							<p class="title">
								<a href="/OurCommunity/gallery/detail?no=${vo.no }">${vo.title}</a>
							<p class="id">${vo.id}</p> <c:forEach var="c" items="${cntList }">
								<c:if test="${c.boardNO eq vo.no}">
									<p>덧글수:[${c.commentCnt }]</p>
								</c:if>
							</c:forEach>

							<p>조회 : ${vo.checkCnt}</p>
							<p>등록일 : ${vo.regDate}</p>

						</li>
					</c:forEach>

				</ul>
			</div>
				
	</div>
	<div class="paging" align="center" >
				<c:choose>
					<c:when test="${searchPage eq 1 }">
						<c:forEach var="i" begin="1" end="${size }">
							<a href="/OurCommunity/gallery/list?page=${i}"> <input
								type="button" value="[${i}]" />
							</a>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach var="i" begin="1" end="${size }">
							<a
								href="/OurCommunity/gallery/list?select=${select}&page=${i}&search=${search}">
								<input type="button" value="[${i}]" />
							</a>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			
			<c:if test="${!empty userId }">
				<div class="button" align="right">
					<a href="/OurCommunity/jsp/community/gallery/write.jsp">글등록</a>
				</div>
			</c:if>
		</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>
</html>