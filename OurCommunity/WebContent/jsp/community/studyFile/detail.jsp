<%@page import="org.apache.coyote.Request"%>
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

.comm, .commB {
	color: black;
}
</style>

<script type="text/javascript">
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/OurCommunity/studyFile/delete?no=${file.no}";
		}
	}
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
			location.href = "/OurCommunity/studyFile/updateWrite?no=${file.no}";
		}
	}
</script>
<style>
table {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>학습 게시판</h1>
		<hr />
		<div class="layerWrap">
			<c:set var="file" value="${file}" />
			<c:if test="${!empty userId}">
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/jsp/community/studyFile/write.jsp'">
				<span class="glyphicon glyphicon-pencil"></span> 글등록
			</button>
			</c:if>
			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/studyFile/list'">
				<span class="glyphicon glyphicon-list-alt"></span> 목록
			</button>

			<button type="button" class="btn btn-default btn-sm"
				onclick="doModify();">
				<span class="glyphicon glyphicon-edit"></span> 수정
			</button>
			<button type="button" class="btn btn-default btn-sm"
				onClick="doDelete();">
				<span class="glyphicon glyphicon-trash"></span> 글삭제
			</button>
			<p>



			<%-- 		<c:if test="${grade eq '회원'}"> --%>
			<%-- 		</c:if> --%>
			<table>
				<tr>
					<th width="10%">말머리</th>
					<td width="90%">${file.type}</td>
				</tr>
				<tr>
					<th width="10%">제목</th>
					<td width="90%">${file.title}</td>
				</tr>
				<tr>
					<th width="10%">다운로드</th>
					<td width="90%"><a
						href="/OurCommunity/studyFile/download?orgFileName=${file.originFileName}&realFileName=${file.realFileName}&readPath=${file.filePath}">${file.originFileName}</a></td>
				</tr>
				<tr>
					<th width="10%">작성자</th>
					<td width="90%">${file.id}</td>
				</tr>
				<tr>
					<th width="10%">작성일</th>
					<td width="90%">${file.regDate}</td>
				</tr>
				<tr>
					<th width="10%">조회수</th>
					<td width="90%">${file.checkCnt}</td>
				</tr>
				<tr>
					<th height="200px" width="10%">내용</th>
					<td width="90%">${file.content}</td>
				</tr>

			</table>
			<p>
			<form action="/OurCommunity/studyFile/comment" method="post">
				<div>
					<input type="hidden" value="${file.id}" name="id" /> <input
						type="hidden" value="${file.no}" name="no" />
				</div>
				<table id="commTable">

					<c:forEach var="cList" items="${cList}">
						<tr>
							<th width="10%">${cList.id}</th>
							<td width="60%">${cList.content}</td>
							<td width="20%" align="right">${cList.regDate}</td>
							<%-- 							<c:if test="${id eq cList.id}"> --%>
							<%-- 							</c:if> --%>
							<td width="10%" align="right">
							<a href="/OurCommunity/studyFile/deleteComment?commentNo=${cList.commentNo}&no=${cList.no}">삭제</a></td>
						</tr>
					</c:forEach>
					<tr>
						<th width="10%">댓글</th>
						<td width="90%" colspan="3"><input class="comm" type='text'
							size='163px' style='height: 100px' name="comment"
							placeholder="댓글을입력하세요" required autofocus />
						<input class="commB" type="submit" value="작성"
							size='350px' style='height: 100px' /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>