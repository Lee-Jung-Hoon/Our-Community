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
	<h1>상세목록</h1>
	<hr />
	<table align="center" style="width: 50%" border="1">
	<tr>
		<th>작성자</th>
		<td >${anonymity.id}</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td >${anonymity.checkCnt}</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${anonymity.title}</td>
	</tr>
	<tr>
		<th>등록시간</th>
		<td>${anonymity.regDate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td style="height: 200px">${anonymity.content}</td>
	</tr>
	<tr>
		<td colspan="4">
			<a href="/OurCommunity/Anonymity/list">목록</a>
			<a href="/OurCommunity/Anonymity/modifyForm?no=${anonymity.no}">수정</a>
			<a href="/OurCommunity/Anonymity/delete?no=${anonymity.no}">삭제</a>
		</td>
	</tr>
	</table>
		<br /><br />
	<table style="width: 50%" border="1" align="center">
	<tr>
		<th >댓글</th><th>내용</th><th>등록일</th>
	</tr>
	<c:forEach var="comment" items="${comment}" >
	<tr>
		<td align="center" width="15%">${comment.id}</td>
		<td align="center" width="55%">${comment.content}</td>
		<td align="center" width="25%">${comment.regDate}</td>
		<td width="5"><a href="/OurCommunity/Anonymity/Cdelete?no=${anonymity.no}&comment_no=${comment.commentNo}">삭제</a></td>
	</tr>
	</c:forEach>
	<c:if test="${empty comment}">
		<td colspan="3">등록된 댓글이 없습니다.</td>
	</c:if>
	</table>
	<br /><br />
	<form action="/OurCommunity/Anonymity/comment" method="POST">
      <table style="height: 500;" align="center">

			<tr>
				<td colspan="3">
					<h3 align="center">댓글 등록</h3> 
					<input type="hidden" name="no" value="${anonymity.no}" />
				</td>
			</tr>
			<tr>
         	<td><input type="text" size="15" name="id" /></td>
            <td colspan="3"><input type="text" size="80" name="content" /></td>
            <td align="right"><input type="submit" value="등록" ></td>
         </tr>
      </table>
	</form>

</body>
</html>