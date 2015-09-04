<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align = "center">일이닷정보</h1>
		<hr />
			<table border="1" style="width:60%;" align="center">
				<tr>
					<th>번호</th>
					<th>회사이름</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
				<%-- DB Table --%>
		<c:forEach var="wInfo" items="${workInfoList}">
			<tr>
				<td>${wInfo.no}</td>
				<td>${wInfo.company}</td>
				<td><a href = "/OurCommunity/workInfo/detail?no=${wInfo.no}">${wInfo.title}</a></td>
				<td>${wInfo.postingTimeStamp} (~${wInfo.expirationTimeStamp}까지)</td >
				<td>${wInfo.checkCnt}</td>
			</tr>
		</c:forEach>
		</table>
		<div  style="text-align:center" >
		<c:forEach var ="index" begin="1" end="${pagingSize}" >
					<a href="/OurCommunity/workInfo/list?pagenum=${index}&searchlist=${search}&content=${content}">[${index}]</a>
		</c:forEach>
		</div> 
		<br />
	<form action="/OurCommunity/workInfo/list" method="get">
		<table border="1" style="width:60%;" align="center" >
			<tr>
				<td>
					<select name="searchlist" >
						<option value="no">번호</option>
						<option value="title" >제목</option>
						<option value="company" >회사이름</option>
					</select>
					<input type="text" name="content" />
					<input type="submit" value="검색"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>