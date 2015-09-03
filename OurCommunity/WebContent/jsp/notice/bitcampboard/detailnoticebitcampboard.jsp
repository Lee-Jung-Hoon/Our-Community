<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<%@ include file="/jsp/include/topMenu.jsp"%>
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
	<form
		action="/OurCommunity/bitcampboard/NoticeBitcampCommentBoardController"
		method="post">
		${board.title} | <a
			href='/OurCommunity/bitcampboard/NoticeBitcampListBoardController'>비트캠프
			공지사항</a>
		<hr />
		<small> <a href='#'
			onclick="window.open('/MyProject/ca/MemberInfoController?id=${board.id}', '회원정보', 
					'width=300, height=300,scrollbars=no, menubar=no, status=no, toolbar=no');">${board.id}</a>
			| 조회 ${board.checkCnt} | 추천 0 | ${board.regDate}
		</small>
		<hr />
		<br /> ${board.content}<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<hr />
		<c:forEach var="list" items="${list}">
			<table>
				<tr>
					<td width="300px">${list.id}</td>
					<td width="900px">${list.content}</td>
					<td width="400px">${list.regDate}</td>
					<c:if test="${id eq list.id}">
						<td width="50px"><a	href="/OurCommunity/bitcampboard/NoticeBitcampDeleteCommentBoardController?no=${list.commentNo}&writeNo=${list.no}">삭제</a></td>
					</c:if>
				</tr>
			</table>
		</c:forEach>
		<table>
			<tr>
				<td><input type="hidden" value="${board.no}" name="no" /></td>
				<td><input type='text' size='200px' style='height: 100px'
					name="comment" placeholder="댓글을 입력하세요." /></td>
				<td><input type="submit" value="작성" size='350px'
					style='height: 100px' /></td>
			</tr>
		</table>
	</form>

</body>
</html>