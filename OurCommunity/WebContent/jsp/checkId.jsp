<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript">

function apply(id){
	opener.document.joinForm.id.value = id;
	window.close();
}
</script>
</head>
<body>

<div>


<c:choose>
<c:when test="${ bl eq false }">
<h1> ${id } 는 이미 사용중입니다.</h1>
<form action="/OurCommunity/member/chkId">
<span>아이디&nbsp;&nbsp;</span><input type="text" name="id" placeholder=" 2자리이상 " >
<input type="submit" value="확인" />
</form>
</c:when>


<c:otherwise>
<h1> ${id } 는 사용하실수 있습니다.</h1>
<input type="button" value="사용하기" onclick="apply(${id});"/>
<br/>
<br/>
<br/>
<hr>
<form action="/OurCommunity/member/chkId">
<h2>다른 아이디 사용</h2>
<span>아이디&nbsp;&nbsp;</span><input type="text" name="id" placeholder=" 2자리이상 " >
<input type="submit" value="확인" />
</form>
</c:otherwise>
</c:choose>




</div>

</body>
</html>