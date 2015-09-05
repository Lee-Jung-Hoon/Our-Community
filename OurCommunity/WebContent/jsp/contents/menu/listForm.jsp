<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
html {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background: url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}
	
body {
	color : white;
}

.bitcampdiv table {
    border-top: 2px solid #cd5d31;
}

a {
	color: white;	
	text-decoration : none;
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
    color : white;
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
}

</style>

</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>오늘의 맛집 추천</h1>
		<hr />
		
	<div class="layerWrap">
			<div class="search_box">
			<form action="/OurCommunity/menu/list">
			검색 구분  <select name="type">
					<option value="id">작성자</option>
					<option value="content">내용</option>
					<option value="title">제목</option>
					<option value="restaurant_name">장소</option>
				</select> <input type="text" name="search" /> <input type="submit"
					value="검색" />
			</form>
		</div>
		<input type="button" value="글쓰기"
			onclick="location.href='/OurCommunity/jsp/contents/menu/registForm.jsp'"><p />
			
		<table border="1" align="center">
			<tr>
				<th align="center" width="100px">글번호</th>
				<th align="center" width="600px">제목</th>
				<th align="center" width="200px">작성자</th>
				<th align="center" width="200px">작성일</th>
				<th align="center" width="200px">조회</th>
			</tr>

			<c:forEach var="menu" items="${list}">
				<tr>
					<td align="center" width="100px">${menu.num}</td>
					<td align="center" width="600px"><a
						href="/OurCommunity/menu/detail?num=${menu.num}">${menu.title}</a></td>
					<td align="center" width="200px">${menu.id}</td>
					<td align="center" width="200px">${menu.regDate}</td>
					<td align="center" width="200px">${menu.count}</td>
				</tr>
			</c:forEach>
		</table>
		<hr/>
		<div align="center">
			<c:forEach var="i" begin="1" end="${pageLeng}">
				<a
					href="/OurCommunity/menu/list?pageNum=${i}&type=${type}&search=${search}">[${i}]</a>
			</c:forEach>
		</div>

	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>