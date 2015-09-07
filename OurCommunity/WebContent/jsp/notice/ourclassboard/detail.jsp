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

<style type="text/css">
body {
   font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
      Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
   font-size: 15px;
   color: white;
   background:
      url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
}

body {
   color: white;
}

table {
   color: white;
}

.bitcampdiv table {
   border-top: 5px solid #cd5d31;
}

a {
   color: white;
   text-decoration: none;
}

.bitcampdiv table td {
   padding: 6px 10px;
   border: 0.5px solid silver;
   overflow: hidden;
   background: #373737;
}

.bitcampdiv table th {
   text-align: center;
   padding: 13px 10px;
   background: #5A5A5A;
   border: 0.5px solid silver;
   padding: 13px 10px;
}

.bitcampdiv h1 {
   font-size: 55px;
   line-height: 35px;
   height: 41px;
   padding: 42px 0;
   text-align: center;
   color: #fff;
}

.search_box {
   background: #cd5d31;
   padding: 15px 20px;
   -moz-border-radius: 5px;
   -webkit-border-radius: 5px;
   border-radius: 5px;
   font-weight: bold;
}

.layerWrap {
   position: relative;
   width: 1400px;
   margin: 100px auto 50px;
   overflow: hidden;
   background: #2d2d2d;
   padding: 40px 40px;
}

table {
   width: 100%;
   height: 100%
}

.conDIV {
	color: black;
}
</style>
</head>

<body>
   <div class="bitcampdiv">
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
         <div class="layerWrap">

            <input type="button" value="목록"
               onclick="location.href='/OurCommunity/ourclassboard/list'">
            <c:if test="${userId eq board.id}">
               <input type="button" value="수정" onclick="doModify();">
               <input type="button" value="삭제" onclick="doDelete();">
            </c:if>
            </form>
            <p>
            <table border="1" align="center">

               <tr>
                  <th>글번호</th>
                  <td>${board.no}</td>
               </tr>
               <tr>
                  <th>글머리</th>
                  <td>${board.boardhead}</td>
               </tr>
               <tr>
                  <th>제목</th>
                  <td>${board.title}</td>
               </tr>
               <tr>
                  <th>작성자</th>
                  <td>${board.id}</td>
               </tr>
               <tr>
                  <th>작성일</th>
                  <td>${board.regDate}</td>
               </tr>

               <tr>
                  <th height="200px">내용</th>
                  <td colspan="2">${board.content}</td>
               </tr>
            </table>
            <p>
            
      <table  border="1" align="center">
         <tr>
            <th>아이디</th>
            <th>내용</th>
            <th colspan="2">등록일</th>
         </tr>

         <c:forEach var="comment" items="${list}">
            <tr>
               <td width="15%" align="center">${comment.id}</td>
               <td width="65%" align="center">${comment.content}</td>
               <td width="30%" colspan="2" align="left">${comment.regDate}

               <c:if test="${userId eq comment.id}">
                  <a href="/OurCommunity/ourclassboard/commentDelete?commentNo=${comment.commentNo}&no=${board.no}">삭제</a>
               </c:if>
               </td>
            </tr>
         </c:forEach>
         <c:if test="${empty list }">
            <td colspan="3">등록된 댓글이 없습니다</td>
         </c:if>

         <form action="/OurCommunity/ourclassboard/commentWrite" method="post">
            <input type="hidden" value="${board.no}" name="no">
            <tr>
            	<th>댓글</th>
               <td colspan="2" class="conDIV"><input type="text" size="142" name="content">
              
                <button type="submit" class="btn btn-default btn-sm">
          			<span class="glyphicon glyphicon-pencil"></span> 댓글등록 
        		</button>
               </td>
            </tr>
      </form>
      </table>
         </div>
      <br /> <br />
      </div>

</body>
</html>