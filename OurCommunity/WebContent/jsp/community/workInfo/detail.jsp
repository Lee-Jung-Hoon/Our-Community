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
 <table align="center" style="width: 50%" border="1">
 	<tr>
		<td colspan="4">
			<a href="/MyProject/main.jsp"><button>홈이닷</button></a>
			<a href="/MyProject/board/writeBoard?no=${board.no}"><button>게시글 수정</button></a>
			<a href="#" onclick="doDelete()"><button>게시글 삭제</button></a>
		</td>
	</tr>
	 <c:set var = "info" value="${info}" />
	 	<tr style="height: 150px">
	 		<td> &nbsp - 제목 : ${info.title} <br /><br />
	 		     &nbsp -  회사 : ${info.company} <br /><br />
	 		     &nbsp -  등록일 : ${info.postingTimeStamp} <br /><br />
	 		     &nbsp - 조회수 : ${info.checkCnt} <br />
	 		 </td>
 		</tr>
	</table>
<table align="center" style="width: 50%" border="1">
	<tr>
		<th align="left">▶제목</th>
		<td colspan="3">title</td>
	</tr>
	<tr>
		<th align="left">▶기관명</th>
		<td>dddd</td>
		<th align="left">▶등록일</th>
		<td>ddd</td>
	</tr>
	<tr>
		<th align="left"  colspan="1">▶마감일</th>
		<td colspan="3">aaaaa</td>
	</tr>
	<tr>
		<th align="left">▶링크</th>
		<td  colspan="3">dddd</td>
	</tr>
	<tr>
		<th align="left">▶채용직급</th>
		<td  colspan="3">dddd</td>
	</tr>
	</table>

	<table>
 				
	</table>
 	 <br /><br />
 	  <h2 align="center" >댓글 달아라~</h2>
	 <form action="/MyProject/board/commentBoard" method = "post">
	 	<input type="hidden" name="no" value="${board.no}" />
	 	<input type="hidden" name="writer" value="${user.id}" />
		 <table align="center" style="width: 50%">
		 	<tr>
		 		<td><input type="text" name = "context" size ="70" /> &nbsp; <input type="submit" value="등록" /></td>
		 	</tr>
		 		
		 </table>
	 </form>
	 
	 <br /><br />
		 <table align="center" style="width: 50%">
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
</body>
</html>