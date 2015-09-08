<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="/jsp/include/bootstrap.jsp" />
<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
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
	color: white;
	padding: 6px 10px;
	border: 0.5px solid silver;
	overflow: hidden;
	background: #373737;
	padding: 6px 10px;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
	color: white;
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
	height: 100%;
}

.comm, .commB {
	color: black;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">${vo.no}번게시물</h1>
		<hr />
		<br />
		<div class="layerWrap">
			<c:if test="${!empty userId }">
				<button type="button" class="btn btn-default btn-sm"
					onclick="location.href='/OurCommunity/jsp/community/gallery/write.jsp'">
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
			</c:if>
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/gallery/list'">
				<span class="glyphicon glyphicon-list-alt"></span> 목록
			</button>
			<c:if test="${vo.id eq userId}">
				<button type="button" class="btn btn-default btn-sm"
					onclick="location.href='/OurCommunity/gallery/modifyDetail?no=${vo.no}'">
					<span class="glyphicon glyphicon-edit"></span> 수정
				</button>
				<button type="button" class="btn btn-default btn-sm"
					onClick="location.href='/OurCommunity/gallery/delete?no=${vo.no}'">
					<span class="glyphicon glyphicon-trash"></span> 글삭제
				</button>
			</c:if>

			<p>





				<form action="/OurCommunity/gallery/regist" method="post"
				enctype="multipart/form-data">

				<table style="height: 500;"center"><tr>
					<th>제목</th>
					<td class="title">${vo.title}</td>
					<th>작성일</th>
					<td class="date" align="right">${vo.regDate}</td>
				</tr>
				<tr class="cnt">
					<th>조회수</th>
					<td>${vo.checkCnt }</td>
					<th>덧글수
					<td>${cntVO.commentCnt}</td>
				</tr>


				<tr>
					<th>작성자</th>
					<td colspan="3">${userId}
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><img src="${vo.filePath}/${vo.fileName}">
						<br /> <br />
						<p>${vo.content}</p> <br /> <br /> <br /> <br /> <br /></td>
				</tr>

				</table>
			</form>


			<table>
				<tr>
					<form action="/OurCommunity/gallery/comment/regist" method="post">
						<c:if test="${!empty userId }">

							<th width="10%">댓글</th>
							<td width="90%" colspan="3"><input class="comm" type='text'
								size='160px' style='height: 100px' name="content"
								placeholder="댓글을입력하세요" required autofocus /> <input
								class="commB" type="submit" value="작성" size='350px'
								style='height: 100px' /></td>
							<input type="hidden" name="id" value="${userId}" />
							<input type="hidden" name="no" value="${vo.no }" />
						</c:if>
					</form>
				</tr>
				<form action="/OurCommunity/gellery/comment/delete" method="get">
					<c:forEach var="cVO" items="${cList}">

						<tr height="50px">

							<td align="center" width="15%">${cVO.id}</td>
							<td width="75%">${cVO.commentContent}</td>
							<td width="15%">${cVO.commentRegDate}</td>

							<c:choose>
								<c:when test="${ !empty userId && userId eq cVO.id }">
									<td width="5%"><input type="hidden" value="${cVO.id}"
										name="id" /> <input type="hidden" value="${cVO.commentNo}"
										name="coNo" /> <input type="hidden" value="${cVO.boardNo}"
										name="no" /> <input type="submit" value="삭제" /></td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</form>

			</table>
		</div>
	</div>
	</div>
</body>
</html>