<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	padding-left: 10px;
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
}

.bitcampdiv table th {
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
	background: #1F1F1F;
	color: white;
	text-align: center;
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

.scope {
	color: white;
}

.write {
	color: white;
}

.file {
	color: white;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<div class="bitcampdiv">
		<%@ include file="/jsp/include/topMenu.jsp"%>
		<h1>Class Board</h1>
		<hr />
		<div class="layerWrap">
			<a href="/OurCommunity/ourclassboard/list"><button>목록</button></a>
			<form action="/OurCommunity/ourclassboard/write" method="post">
				<table border="1" align="center">
					<tr>
						<th>글머리</th>
						<td><select name="boardhead">
								<option value="공지사항">공지사항</option>
								<option value="자유게시판">자유게시판</option>
						</select></td>
					</tr>

					<tr>
						<th align="center">TITLE</th>
						<td><input name="title" size="50" maxlength="100"></td>
					</tr>

					<tr>
						<th align="center">CONTENT</th>
						<td><textarea name="content" cols="150" rows="12"
								placeholder="이곳에 내용을 입력하세요"></textarea></td>
					</tr><tr>
						<td class="scope" colspan="2" align="center"><input
							type="radio" name="scope" checked="checked" value="전체">전체공개
							<input type="radio" name="scope" value="멤버">멤버공개</td>
					</tr>

					<tr align="center">
						<td colspan="2"><input type="submit" value="글등록"> <input
							type=reset value="재작성"></td>
					</tr>
					
				</table>
			</form>
		</div>
	</div>

</body>
</html>