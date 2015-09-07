<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
 			location.href = "/OurCommunity/ourclassboard/modify?no=${board.no}";
 		}
 	}
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
 			location.href = "/OurCommunity/ourclassboard/delete?no=${board.no}";
 		}
 	}
</script>
</head>

<body>
	<c:if test="${empty userId}">
		<c:if test="${board.scope eq '멤버'}">
			<script type="text/javascript">
             function memberScope() {
	          location.href = '/OurCommunity/jsp/login.jsp';
             }
             alert("멤버공개 게시물 입니다.");
            memberScope();
        	</script>
        </c:if>
	</c:if>

	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1>반 게시판</h1>
	<hr />

	<form>
		<div style="width: 1000;">
			<table border="1" align="center">

				<tr align="center">
					<th>No</th>
					<td>${board.no}</td>
				</tr>
				<tr align="center">
					<th>Tag</th>
					<td>${board.boardhead}</td>
				</tr>
				<tr align="center">
					<th>Title</th>
					<td>${board.title}</td>
				</tr>
				<tr align="center">
					<th>ID</th>
					<td>${board.id}</td>
				</tr>
				<tr align="center">
					<th>RegDate</th>
					<td>${board.regDate}</td>
				</tr>

				<tr align="center">
					<td colspan="2"><textarea name="content" cols="150" rows="12"
							readonly>${board.content}</textarea></td>
				</tr>
			</table>

			<table align="center">
				<tr>
					<td><input type="button" value="목록"
						onclick="location.href='/OurCommunity/ourclassboard/list'">
						<input type="button" value="수정" onclick="doModify();"> <input
						type="button" value="삭제" onclick="doDelete();"></td>
				</tr>
			</table>
		</div>
	</form>
	<br />
	<br />


	<form action="/OurCommunity/ourclassboard/commentWrite" method="post">
		<input type="hidden" value="${board.no}" name="no">
		<table border="1" align="center" width="30">
			<tr>
				<td><input type="text" name="id"></td>
				<td><input type="text" name="content"></td>
				<td><input type="submit" value="덧글"></td>
			</tr>
		</table>
	</form>


	<table border="2" align="center">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="comment" items="${list}">
			<tr>
				<td>${comment.commentNo}</td>
				<td>${comment.id}</td>
				<td>${comment.content}</td>
				<td>${comment.regDate}</td>
				<td><input type="button" value="삭제"
					onclick="location.href='/OurCommunity/ourclassboard/commentDelete?commentNo=${comment.commentNo}&no=${board.no}'"></td>
			</tr>

		</c:forEach>
		<c:if test="${empty list }">
			<td>등록된 댓글이 없습니다</td>
		</c:if>
	</table>
</body>
</html>