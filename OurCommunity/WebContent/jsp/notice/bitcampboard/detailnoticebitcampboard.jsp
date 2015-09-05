<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
html {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
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
	padding: 6px 10px;
	border: 0.5px solid silver;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid silver;
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
</style>

<script type="text/javascript">
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/OurCommunity/bitcampboard/NoticeBitcampDeleteBoardController?no=${board.no}";
		}
	}
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
			location.href = '/OurCommunity/bitcampboard/NoticeBitcampModifyBoardController?no=${board.no}';
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
		<h1>비트캠프 공지사항</h1>
		<hr />
	<div class="layerWrap">
	
		<c:if test="${grade eq '운영자'}">
			<input type='button' value='글쓰기'
				onclick="location.href='/OurCommunity/jsp/notice/bitcampboard/registnoticebitcampboard.jsp'">
		</c:if>
		<input type='button' value='목록'
			onclick="location.href='/OurCommunity/bitcampboard/NoticeBitcampListBoardController'">
		<c:if test="${grade eq '운영자'}">
			<input type="button" value="수정" onclick="doModify();">
			<input type="button" value="글 삭제" onClick="doDelete();">
		</c:if>
		<hr />
		<table>
			<tr>
				<th width="10%">말머리</th>
				<td width="90%">${board.boardHead}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td width="90%">${board.title}</td>
			</tr>
		
			<tr>
				<th>작성자</th>
				<td width="90%">${board.id}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td width="90%">${board.regDate}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td width="90%">${board.checkCnt}</td>
			</tr>
			<tr>
				<th height="200px">내용</th>
				<td width="90%">${board.content}</td>
			</tr>
		
		</table>
		
		
		
<%-- 			${board.title} | <a --%>
<!-- 				href='/OurCommunity/bitcampboard/NoticeBitcampListBoardController'>비트캠프 -->
<!-- 				공지사항</a> -->
<!-- 			<hr /> -->
<!-- 			<small> <a href='#' -->
<%-- 				onclick="window.open('/MyProject/ca/MemberInfoController?id=${board.id}', '회원정보',  --%>
<%-- 					'width=300, height=300,scrollbars=no, menubar=no, status=no, toolbar=no');">${board.id}</a> --%>
<%-- 				| 조회 ${board.checkCnt} | 추천 0 | ${board.regDate} --%>
<!-- 			</small> -->
<!-- 			<hr /> -->
<%-- 			<br /> ${board.content}<br /> <br /> <br /> <br /> <br /> <br /> --%>
<!-- 			<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> -->
<!-- 			<br /> -->
<!-- 			<hr /> -->
			
			
			
			<p>
			<table>
				
			<form action="/OurCommunity/bitcampboard/NoticeBitcampCommentBoardController"	method="post">
			<c:forEach var="list" items="${list}">
					<tr>
						<th width="10%">${list.id}</th>
						<td width="1100px">${list.content}</td>
						<td width="200px">${list.regDate}</td>
						<c:if test="${id eq list.id}">
							<td width="50px"><a
								href="/OurCommunity/bitcampboard/NoticeBitcampDeleteCommentBoardController?no=${list.commentNo}&writeNo=${list.no}">삭제</a></td>
						</c:if>
					</tr>
			</c:forEach>
			
				<tr>
				<th>댓글</th>
					<input type="hidden" value="${board.no}" name="no" />
					<td colspan="2"><input type='text' size='178px' style='height: 100px'
						name="comment" placeholder="댓글을 입력하세요." /></td>
					<td><input type="submit" value="작성" size='350px'
						style='height: 100px' /></td>
				</tr>
				</form>
			</table>
	</div>
	</div>
	
	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>