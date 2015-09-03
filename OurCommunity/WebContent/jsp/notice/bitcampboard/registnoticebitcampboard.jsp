<%@page import="org.apache.catalina.connector.Response"%>
<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
   <h1 align="center">글 작성</h1>
   <hr />
   <br />
   <form action="/OurCommunity/bitcampboard/NoticeBitcampRegistBoardController" method="post">
      <table style="height: 500;" align="center">
         <tr>
            <th>말머리</th>
            <td><select name="boardHead">
                  <option value="비트캠프 공지사항">비트캠프 공지사항</option>
                  <option value="개강 공지사항">개강 공지사항</option>
                  <option value="기타 공지사항">기타 공지사항</option></select></td>
         </tr>

         <tr>
            <th>제목</th>
            <td colspan="3"><input type="text" size="148" name="title" /></td>
         </tr>

         <tr>
            <th>&nbsp;&nbsp;&nbsp;첨부 파일 종류&nbsp;&nbsp;&nbsp;</th>
            <td colspan="3"><input type="checkbox" name="file_type"
               value="1" checked="checked" /> 동영상 <input type="checkbox"
               name="file_type" value="2" /> 사진 <input type="checkbox"
               name="file_type" value="3" /> 음악 <input type="checkbox"
               name="file_type" value="4" /> 미첨부 &nbsp;&nbsp; <input type="file" />
            </td>
         </tr>

         <tr>
            <th>글 내용</th>
            <td colspan="3"><textarea cols="150" rows="30" name="content"></textarea>
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
            <td></td>
            <td align="right"><input type="submit" value="등록" /></td>
      </table>
   </form>
</body>
</html>