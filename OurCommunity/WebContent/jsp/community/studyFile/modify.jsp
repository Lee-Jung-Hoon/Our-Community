<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.apache.catalina.connector.Request"%>
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
	<%@ include file="/jsp/include/topMenu.jsp"%>
   <h1 align="center">학습게시판 수정</h1>
   <hr />
   <br />
   <form action="/OurCommunity/studyFile/update" method="post" enctype="multipart/form-data">
      <table style="height: 500;" align="center">
      <c:set var = "updateFile" value="${update}" />
         <tr>
         
            <th>&nbsp;&nbsp;&nbsp;말머리&nbsp;&nbsp;&nbsp;</th>
				<td><select name=searchType>
								<option value="">선택하세요</option>
								<option value="Java">Java</option>
								<option value="Sql">Sql</option>
								<option value="CSS">CSS</option>
								<option value="Script">Script</option>
				</select></td>
			<th>업로드 파일</th>
				<td><input type="file" name="userfile" /></td>
			</tr>
			
         <tr>
            <th>제목</th>
            <td colspan="3"><input type="text" size="148" name="title" value="${updateFile.title}"/></td>
         </tr>
         
         <tr>
            <th>글 내용</th>
            <td colspan="3"><textarea cols="150" rows="30" name="content"">${updateFile.content}</textarea>
            </td>
         </tr>

         <tr>
            <th>공개 설정</th>
            <td colspan="3" align="center">
            <input type="radio" name="scope" value="전체공개" checked="checked" /> 전체공개 
               <input type="radio" name="scope" value="멤버공개" /> 멤버공개
         </tr>

         <tr>
            <td></td>
            <td></td>
            <td><input type="hidden" name="no" value="${update.no}" ></td>
            <td align="right"><input type="submit" value="수정 등록" /></td>
      </table>
   </form>
</body>
</html>