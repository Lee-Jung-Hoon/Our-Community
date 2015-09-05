<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
th {
	width: 200px;
}

th, td {
	border-bottom: 1px solid black;
}

body {
	font-family: "nanumgothic", '나눔고딕';
}

table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

a {
	color: #888;
	text-decoration: none;
}

.title {
	font-weight: bold;
	font-size: 30px;
}

.date {
	font-size: 13px;
}

.id {
	font-size: 13px;
}

.cnt {
	font-size: 13px;
}
</style>

</head>
<body>

	<h1 align="center">${vo.no}번게시물</h1>
	<hr />
	<br />
	<form action="/OurCommunity/gallery/regist" method="post"
		enctype="multipart/form-data">
		<table style="height: 500; width: 900px" align="center">

			<tr height="50px">

				<td class="title" colspan="2">${vo.title}</td>
				<td class="date" width="300px" align="right">${vo.regDate}</td>
			</tr>


			<tr>
				<td colspan="3"><p class="id">&nbsp;작성자 :
						&nbsp;&nbsp;&nbsp;${userId}</p> <img
					src="${vo.filePath}/${vo.fileName}" width="100%"> <br /> <br />
					<p>${vo.content}</p> <br /> <br /> <br /> <br /> <br /></td>
				<td></td>
			</tr>
			<tr class="cnt">
				<td></td>
				<td>조회수 : ${vo.checkCnt } 덧글수 : ${cntVO.commentCnt}</td>
				<td></td>
			</tr>




			<tr>
				<td align="right"><br /> <br /> <a
					href="/OurCommunity/gallery/modifyDetail?no=${vo.no}"><input
						type="button" value="수정"> </a></td>
				<td align="right"><a
					href="/OurCommunity/gallery/delete?no=${vo.no}"><input
						type="button" value="삭제"> </a></td>
				<td align="right"><a href="/OurCommunity/gallery/list"><input
						type="button" value="목록"></a></td>
			</tr>
		</table>
	</form>


	<c:if test="${!empty userId }">
		<form action="/OurCommunity/gallery/comment/regist" method="post">
			<table style="height: 500; width: 900px" align="center">
				<tr>
					<td width="10%">${userId}</td>
					<td width="80%"><textarea cols="115" rows="6" name="content"></textarea></td>
					<td align="center"><input type="hidden" name="id"
						value="${userId}" /><input type="hidden" name="no"
						value="${vo.no }" /><input type="submit" value="확인" /></td>
				</tr>
			</table>
		</form>
	</c:if>


	<div>
		<form action="/OurCommunity/gellery/comment/delete" method="get">
			<table style="height: 500; width: 900px" align="center">
				<c:forEach var="cVO" items="${cList}">

					<tr height="50px">

						<td class="a">${cVO.id}</td>
						<td class="b">${cVO.commentRegDate}</td>
					</tr>
					<tr height="50px">

						<td>${cVO.commentContent}</td>

						<c:choose>
							<c:when test="${ !empty userId && userId eq cVO.id }">
								<td><input type="hidden" value="${cVO.id}" name="id" /> <input
									type="hidden" value="${cVO.commentNo}" name="coNo" /> <input
									type="hidden" value="${cVO.boardNo}" name="no" /> <input
									type="submit" value="삭제" /></td>
							</c:when>
						</c:choose>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>





</body>
</html>