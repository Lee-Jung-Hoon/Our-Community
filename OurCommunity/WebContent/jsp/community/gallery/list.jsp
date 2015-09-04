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
	height: 464px;
	margin: 50px auto 0;
	padding: 20px 16px;
/* 	border: 1px solid #ddd; */
	box-sizing: border-box;
}

html{
background-color: orange;
color: white;
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
div{
width: 902px;
margin: 0px auto 0;
}

</style>
</head>
<body>
<h1 align="center">Photo Gallery</h1>
	<div class="wrapper">
		<ul>
			<c:forEach var="vo" items="${list}">
			
				<li>
					<div>
						<a href="/OurCommunity/gallery/detail?no=${vo.no }"><img src="${vo.filePath}/${vo.fileName}" width="100%"></a>
					</div>
					<p class="title"><a href="/OurCommunity/gallery/detail?no=${vo.no }">${vo.title}</a>
					<p class="id">${vo.id}</p>
					
					<c:forEach var="c" items="${cntList }">
					<c:if test="${c.boardNO eq vo.no}"> <p>덧글수:[${c.commentCnt }]</p></c:if>
				</c:forEach>
					
					<p>조회 : ${vo.checkCnt}</p>
					<p>등록일 : ${vo.regDate}</p>
					
				</li>
			</c:forEach>

		</ul>
	</div>
	<div align="center">
	<form action="/OurCommunity/gallery/search" >
	<select><option>기간선택</option><option>1일</option><option>1주일</option><option>1달</option><option>1년</option></select>
	<select name="select"><option value="tatal">제목+내용</option><option value="title">제목</option><option value="content">내용</option><option value="comment">덧글</option><option value="id">아이디</option></select>
	<input type="text" name="search" size="20px"/>
	<input type="submit" size="20px"/>
	</form>
	</div>
	<div>
	
	</div>
	<div align="center">
	<c:forEach var="i" begin="1" end="${size }">

	<a href="/OurCommunity/gallery/list?page=${i}" ><input type="button" value="[${i}]" /></a>
	</c:forEach>
	
	</div>
	
	<div class="button" align="right"> <a href="/OurCommunity/jsp/community/gallery/write.jsp">글등록</a> </div>
</body>
</html>
</body>
</html>