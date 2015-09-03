<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
 <table>
	 <c:set var = "info" value="${info}" />
	 	<tr>
	 		<td>제목 : ${info.title}</td>
	 		<td>회사 : ${info.company}</td>
	 		<td></td>
	 		<td>등록일 : ${info.postingTimeStamp}</td>
	 		<td>조회수 : ${info.checkCnt}</td>
 		</tr>
	</table>
	<table>
 				
	</table>
 	 <br /><br />
 	  <h2>댓글 달아라~</h2>
	 <form action="/MyProject/board/commentBoard" method = "post">
	 	<input type="hidden" name="no" value="${board.no}" />
	 	<input type="hidden" name="writer" value="${user.id}" />
		 <table style="width: 34%">
		 	<tr>
		 		<td><input type="text" name = "context" size ="70" /> &nbsp; <input type="submit" value="등록" /></td>
		 	</tr>
		 		
		 </table>
	 </form>
	 
	 <br /><br />
		 <table>
			<c:forEach var="comment" items="${commentList}" >
				<tr>
						<td>작성자 : ${comment.writer}</td>
						<td>등록일자 :${comment.regDate}</td>
						<td><a href="/MyProject/board/deleteCommentBoard?no=${board.no}&commentNo=${comment.commentNo}">삭제</a></td>
						
				</tr>
				
				<tr>
					<td colspan="3">${comment.context}</td>
				</tr>
			</c:forEach>
			</table>
			<a href="/MyProject/main.jsp">홈이닷</a>
			<a href="/MyProject/board/writeBoard?no=${board.no}">게시글 수정</a>
			<a href="#" onclick="doDelete()">게시글 삭제</a>
</body>
</html>