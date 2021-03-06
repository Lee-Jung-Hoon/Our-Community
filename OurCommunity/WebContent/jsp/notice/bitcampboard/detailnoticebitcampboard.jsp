<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
			location.href = "/OurCommunity/bitcampboard/NoticeBitcampDeleteBoardController?no=${board.no}";
		}
	}
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
			location.href = '/OurCommunity/bitcampboard/NoticeBitcampModifyBoardController?no=${board.no}';
		}
	}
</script>

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
		<h1>비트캠프 공지사항</h1>
		<hr />
		<div class="layerWrap">

			<c:if test="${grade eq '운영자'}">
				<button type="button" class="btn btn-default btn-sm"
					onclick="location.href='/OurCommunity/jsp/notice/bitcampboard/registnoticebitcampboard.jsp'">
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
			</c:if>
			<button type="button" class="btn btn-default btn-sm" onclick="location.href='/OurCommunity/bitcampboard/NoticeBitcampListBoardController'">
					<span class="glyphicon glyphicon-list-alt"></span> 목록
				</button>
			<c:if test="${grade eq '운영자'}">
				<button type="button" class="btn btn-default btn-sm" onclick="doModify();">
         		 <span class="glyphicon glyphicon-edit"></span> 수정
       			 </button>
				<button type="button" class="btn btn-default btn-sm"
					onclick="doDelete();">
					<span class="glyphicon glyphicon-trash"></span> 글 삭제
				</button>
			</c:if>
			<hr />
			<table>
				<tr>
					<th width="10%">말머리</th>
					<td colspan="3" width="90%">${board.boardHead}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3" width="90%">${board.title}</td>
				</tr>

				<tr>
					<th>작성자</th>
					<td colspan="3" width="90%">${board.id}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td width="40%">${board.regDate}</td>
					<th>조회수</th>
					<td width="40%">${board.checkCnt}</td>
				</tr>
				<tr>
					<th height="200px">내용</th>
					<td colspan="3" width="90%">${board.content}</td>
				</tr>

			</table>
		</div>
	</div>

	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>