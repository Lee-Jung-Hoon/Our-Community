<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
.wrapper {
	width: 902px;
	margin: 50px auto 0;
	padding: 20px 16px;
/* 	border: 1px solid #ddd; */
	box-sizing: border-box;
}


a{

color: black;
text-decoration: none;
}


ul {
	width: 110%;
	overflow: hidden;
	padding: 0;
	margin: 0;
}

li {
	float: left;
	width: 156px;
	height: 190px;
	padding: 0;
	margin: 0 20px 20px 0;
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
.title{
font-size: 14px;
font-weight: bold;
overflow: hidden;
text-overflow: ellipsis;
white-space: nowrap;
}

.id{
font-size: 11px
}

.button{
width: 902px;
	margin: 0px auto 0;
	padding: 20px 16px;
	box-sizing: border-box;
}
</style>
</head>
<body>
<body><%@ include file="/jsp/include/topMenu.jsp"%>
<h1 align="center">Photo Gallery</h1>
	<div class="wrapper">
		<ul>
			<c:forEach var="vo" items="${list}">
				<li>
					<div>
						<a href="/OurCommunity/gallery/detail?no=${vo.no }"><img src="${vo.filePath}/${vo.fileName}" width="100%"></a>
					</div>
					<p class="title"><a href="/OurCommunity/gallery/detail?no=${vo.no }">${vo.title}</a></p>
					<p class="id">${vo.id}</p>
					<p>&nbsp;</p>
					<p>조회 : ${vo.checkCnt}</p>
					<p>등록일 : ${vo.regDate}</p>
				</li>
			</c:forEach>

		</ul>
	</div>
	<div class="button" align="right"> <a href="/OurCommunity/jsp/community/gallery/write.jsp">글등록</a> </div>
</body>
</html>





































</body>
</html>