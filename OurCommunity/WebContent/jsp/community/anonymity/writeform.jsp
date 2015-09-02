<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1 align="center">글 작성</h1>
   <hr />
   <br />
   <form action="/OurCommunity/Anonymity/write" method="POST">
      <table style="height: 500;" align="center">
      
         <tr>
            <th>제목</th>
            <td colspan="3"><input type="text" size="148" name="title" /></td>
         </tr>

         <tr>
            <th>글 내용</th>
            <td colspan="3"><textarea cols="150" rows="30" name="content"></textarea>
            </td>
         </tr>

         <tr>
            <th>공개 설정</th>
            <td colspan="2" align="center">
            <input type="radio" name="scope"value="t" checked="checked" /> 전체공개 
            <input type="radio" name="scope" value="m" /> 멤버공개
         </tr>

         <tr>
            <td></td>
            <td></td>
            <td></td>
            <td align="right"><input type="submit" value="등록" ></td>
      </table>
   </form>
</body>
</html>