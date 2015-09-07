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

table {
	color: white;
}

table a {
	color: white;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding: 6px 10px;
	border: 0.5px solid #1f1f1f;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid #2d2d2d;
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
.commentDIV {
		color: black;
}
</style>
<style>
table {
	width: 100%;
	height: 100%;
}

comm_text {
	color: black;
}
</style>

<script type="text/javascript">
	function doDelete() {
		if (confirm("회원을 탈퇴 시키겠습니까?")) {
			location.href = '/OurCommunity/Anonymity/delete?no=${anonymity.no}';
		}
	}
	function doModify() {
		if (confirm("회원정보를 수정하겠습니까?")) {
			location.href = '/OurCommunity/Anonymity/modifyForm?no=${anonymity.no}';
		}
	}
</script>


</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>회원정보 상세목록</h1>
		<hr />

		<div class="layerWrap">

			<button type="button" class="btn btn-default btn-sm"
				onclick="location.href='/OurCommunity/Anonymity/list'">
				<span class="glyphicon glyphicon-list-alt"></span> 목록
			</button>
			<button type="button" class="btn btn-default btn-sm"
				onclick="doModify();">
				<span class="glyphicon glyphicon-edit"></span> 수정
			</button>
			<button type="button" class="btn btn-default btn-sm"
				onclick="doDelete();">
				<span class="glyphicon glyphicon-trash"></span> 회원 탈퇴
			</button>
			<hr />
			<table>
				<tr>
					<th>아이디</th>
					<td colspan="3" width="90%">${memberDetail.id}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td width="40%">${memberDetail.name}</td>
					<th>조회수</th>
					<td width="40%">${memberDetail.password}</td>
				</tr>
				<tr>
					<th height="200px">내용</th>
					<td colspan="3" width="90%">${memberDetail.emailId}</td>
				</tr>

			</table>


			<p>
			<table align="center">
				<c:forEach var="comment" items="${comment}">
					<tr>
						<th width="10%">${comment.id}
						</td>
						<td width="1100px">${comment.content}</td>
						<td width="200px">${comment.regDate}</td>
						<c:if test="${userId eq comment.id}">
							<td width="50px"><a
								href="/OurCommunity/Anonymity/Cdelete?no=${anonymity.no}&comment_no=${comment.commentNo}">삭제</a></td>
						</c:if>
					</tr>
				</c:forEach>
				<c:if test="${empty comment}">
					<td colspan="4">등록된 댓글이 없습니다.</td>
				</c:if>

				<c:if test="${!empty userId}">
					<form action="/OurCommunity/Anonymity/comment" method="POST">
						<tr>
							<th>댓글</th>
							<input type="hidden" name="no" value="${anonymity.no}">
							<td colspan="2" class="commentDIV"><input type='text'
								size='160px' style='height: 100px' name="content"
								placeholder="댓글을 입력하세요." /></td>
							<td>
								<button type="submit" class="btn btn-default btn-sm">
									<span class="glyphicon glyphicon-pencil"></span> 등록
								</button>
							</td>
						</tr>
					</form>
				</c:if>
			</table>

		</div>
	</div>

</body>
</html>