<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	font-size: 15px;
	
	color : white;
	background:	url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
	color: white;
}

table {
	
	color : white;
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding: 6px 10px;
	border: 0.5px solid silver;
	overflow: hidden;
	color: balck;
	background: #373737;
}

.bitcampdiv table th {
	text-align: center; padding : 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
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
	height: 100%
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
<c:if test="${empty id}">
		<c:if test="${scope eq '멤버공개'}">
			<script type="text/javascript">
				function memberScope() {
					alert("회원 공개 게시글입니다.");
					location.href = '/OurCommunity/jsp/login.jsp';
				}
				memberScope();
			</script>
		</c:if>
	</c:if>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>학습 게시판</h1>
		<hr />
		<div class="layerWrap">
			<c:set var="file" value="${file}" />
				<c:if test="${grade eq '회원'}">
					<input type='button' value='글쓰기'
						onclick="location.href='/OurCommunity/jsp/community/studyFile/write.jsp'">
				</c:if>
			<input type='button' value='목록'
				onclick="location.href='/OurCommunity/studyFile/list'">
			<c:if test="${grade eq '회원'}">
				<input type="button" value="수정" onclick="doModify();"> <input
						type="button" value="글 삭제" onClick="doDelete();">
			</c:if>
			<hr />

			<table>
				<tr>
					<th width="10%">말머리</th>
					<td width="90%">${file.type}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td width="90%">${file.title}</td>
				</tr>
				<tr>
					<th>다운로드</th>
					<td width="90%"><a
						href="/OurCommunity/studyFile/download?orgFileName=${file.originFileName}&realFileName=${file.realFileName}&readPath=${file.filePath}">${file.originFileName}</a></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td width="90%">${file.id}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td width="90%">${file.regDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td width="90%">${file.checkCnt}</td>
				</tr>
				<tr>
					<th height="200px">내용</th>
					<td width="90%">${file.content}</td>
				</tr>

			</table>
		<p>
			<form action="/OurCommunity/studyFile/comment" method="post">
				<div>
					<input type="hidden" value="${file.id}" name="id" /> <input
						type="hidden" value="${file.no}" name="no" />
				</div>
				<table>

					<c:forEach var="cList" items="${cList}">
						<tr>
							<th width="10%">${cList.id}</th>
							<td width="1100px">${cList.content}</td>
							<td width="200px">${cList.regDate}</td>
							<c:if test="${id eq cList.id}">
								<td width="50px"><a
									href="/OurCommunity/studyFile/deleteComment?commentNo=${cList.commentNo}&no=${cList.no}">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
					<tr>
						<th>댓글</th>
						<td colspan="2"><input type='text' size='178px'
							style='height: 100px' name="comment" placeholder="댓글을입력하세요" /></td>
						<td><input type="submit" value="작성" size='350px'
							style='height: 100px' /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>