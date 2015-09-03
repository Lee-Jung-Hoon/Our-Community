<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

 function voteCheck()
{
  var frm = document.detVote;
  
  for( var i = 0; i <= frm.elements.length - 1; i++ ){
     if( frm.elements[i].name == "voteSubmit" )
     {
         if( !frm.elements[i].value ){
             alert("투표 값을 선택 해주세요!!");
             frm.elements[i].focus();
             return;
          } else {
        	  document.detVote.submit(); 
          }
      }
   }
 } 
 
 function registVote() {
	 document.regist.submit(); 
}
 function listVote() {
	 document.list.submit(); 
}
 
</script>

<style>
	
	table {
		border-collapse: collapse;	
		align:"center";
		width: 80%;

	}

</style>
</head>
<body>
	<h1 align="center">투표 조회</h1>
	<hr />
	<br />
	
 	<form action="/OurCommunity/jsp/contents/vote/registVoteForm.jsp" name = "regist">
	<table align="left">
		<tr>
			<td>
				<input type="button" name="regist" value="글쓰기" onClick="registVote();">
			</td>
		</tr>
	</table>
	</form>	
	
 	<form action="/OurCommunity/vote/listVote" name = "list">
	<table>
		<tr>
			<td>
				<input type="button" name="list" value="목록" onClick="listVote();">
			</td>
		</tr>
	</table>
	</form>
	
	<c:if test="${id eq list.id}">	
 	<form action="/OurCommunity/vote/deleteVote?v_no=${list.v_no}" name = "deletes">
	<table>		
		<tr>	
			<td>
				<input type="button" name="deletes" value="투표삭제" onClick="location.href='/OurCommunity/vote/deleteVote?v_no=${list.v_no}'">
			</td>
		</tr>
	</table>
	</form>
	</c:if>					
	
	<form action="/OurCommunity/web/checkVote" name = "detVote">
	<table border="1px" align="center">
		<tr>
			<th>작성자</th>
			<td colspan="3">${list.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${list.v_title}</td>
		</tr>
		<tr>
			<th>시작일</th>
			<td>${list.start_date}</td>
			<th>종료일</th>
			<td>${list.end_date}</td>
		</tr>
		<tr>
			<td colspan="2">
			<th>투표인원</th>
			<td>${list.v_progress}</td>
		</tr>
	</table>
	<table border="1px" align="center">
		<c:forEach var="item" items="${ilist}">
		<tr>
			<td><input type="radio" name = "voteSubmit" value="${item.subsection}">
				${item.subsection}<br />
			</td>
			<td> 투표수 : ${item.count} </td>
		</tr>
		</c:forEach>
		
		<tr>
			<input type="hidden" name = "v_no" value="${list.v_no}">
			<td colspan="2" align="right"><input type="button" name="checkvote" value="투표" onClick="voteCheck();">
			</td>
		</tr>
		
	</table>
	
	</form>
	

</body>
</html>