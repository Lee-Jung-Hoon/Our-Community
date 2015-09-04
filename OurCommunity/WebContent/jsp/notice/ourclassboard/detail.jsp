<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/BoardTestT/board/delete?no=${board.no }";
		}
	}
</script>
</head>
<body>
<h1>반 게시판</h1>
<hr />

	<form>
		<div style="width: 1000;">
				<table border="1" align="center">		
							
					<tr align="center">
						<th >No</th>
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
					<td colspan="2"><textarea name="content" cols="150" rows="12" readonly>${board.content}</textarea></td>			
					</tr>
					</table>
					
					<table align="center">
			
					<td><a href="/Community/ourclassboard/list">목록</a> 
					<a href="/Community/ourclassboard/modify?no=${board.no }">수정</a> 
					<a href="/Community/ourclassboard/delete?no=${board.no }">삭제</a></td>
				</table>
			</div>
	</form>
	<br />
	<br />


	<form action="/Community/ourclassboard/commentWrite" method="post">
		<input type="hidden" value="${board.no}" name="no">
		<table border="1" align="center" width="30">
			<tr>
				<td><input type="text" name="id"></td>
				<td><input type="text" name="content"></td>
				<td><input type="submit" value="commet"></td>
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
				<td><a
					href="/Community/ourclassboard/commentDelete?commentNo=${comment.commentNo}&no=${board.no}">delete</a></td>
			</tr>

		</c:forEach>
		<c:if test="${empty list }">
			<td>등록된 댓글이 없습니다</td>
		</c:if>
	</table>
</body>
</html>