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
 <table align="center" style="width: 50%" border="1">
 	<tr>
		<td colspan="4">
			<a href="/OurCommunity/jsp/community/workInfo/main.jsp"><button>홈이닷</button></a>
			<a href="#" onclick="doDelete()"><button>게시글 삭제</button></a>
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
	<br /><br />
<table align="center" style="width: 50%" border="1">
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
	</table>
</body>
</html>