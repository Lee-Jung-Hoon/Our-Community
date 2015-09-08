<%@page import="org.apache.coyote.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	border: 0.9px solid silver;
	overflow: hidden;
	background: #373737;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.9px solid silver;
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
</style>

<script type="text/javascript">
	function doDelete() {
		if (confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/OurCommunity/adminboard/NoticeAdminDeleteBoardController?no=${board.no}";
		}
	}
	function doModify() {
		if (confirm("게시물을 수정하시겠습니까?")) {
			location.href = '/OurCommunity/adminboard/NoticeAdminModifyBoardController?no=${board.no}';
		}
	}
</script>
<style>
table {
	width: 100%;
	height: 100%
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
<form action="/OurCommunity/mypage/personalUpdate" method="post"
				onsubmit="return chkForm();" name="joinForm">
				<table width="600" height="600 " color="#FF8224">
					<tr>
						<th colspan="2" align="center">개인정보 수정</th>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name" value="${vo.name }"></td>
					</tr>
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"  value="${vo.id }"> <input
							type="button" name="idbutton" value="중복확인" onclick="chkId();"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="password" ></td>
					</tr>
					<tr>
						<th>비밀번호 재입력</th>
						<td><input type="password" name="repassword" ></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="tel"  value="${ vo.tel}"></td>
					</tr>
					<tr>
						<th>성별</th>
						<td><input type="radio" name="gender" checked="checked" value="남자" >남자 <input
							type="radio" name="gender" value="여자">여자</td>
					</tr>
					<tr align="left">
						<th align="center">E-Mail
						<th><input type="text" name="emailId" value="${vo.emailId }"> @ 
						
						<c:choose>
						<c:when test="${vo.emailDomain eq '다음'}">
						
						
						<select
							name="emailDomain">
								<option value="네이버">naver.com</option>
								<option value="다음" selected="selected">daum.net</option>
								<option value="구글">google.com</option>
						</select>
						</c:when>
						<c:when test="${vo.emailDomain eq '네이버'}">
						
						
						<select
							name="emailDomain">
								<option value="네이버" selected="selected">naver.com</option>
								<option value="다음" >daum.net</option>
								<option value="구글">google.com</option>
						</select>
						</c:when>
						<c:when test="${vo.emailDomain eq '구글'}">
						
						
						<select
							name="emailDomain">
								<option value="네이버">naver.com</option>
								<option value="다음" >daum.net</option>
								<option value="구글" selected="selected">google.com</option>
						</select>
						</c:when>
						</c:choose>
						
						
						
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="address" size="52" value="${vo.address }"></td>
					</tr>
					<tr>
						<th>가입 힌트</th>
						<c:choose>
						<c:when test="${vo.hint eq '출신초' }">
						<td><select name="hint">
								<option value="출신초" selected="selected">출신 초등학교는 어디인가요?</option>
								<option value="책 이름">가장 감명 깊게 읽은 책 이름은?</option>
								<option value="고향">본인이 태어난 곳은?</option>
								<option value="어머니">본인의 어머니 성함은?</option>
								
						</select></td>
						</c:when>
						<c:when test="${vo.hint eq '책이름' }">
						<td><select name="hint">
								<option value="출신초" >출신 초등학교는 어디인가요?</option>
								<option value="책 이름" selected="selected">가장 감명 깊게 읽은 책 이름은?</option>
								<option value="고향">본인이 태어난 곳은?</option>
								<option value="어머니">본인의 어머니 성함은?</option>
								
						</select></td>
						</c:when>
						<c:when test="${vo.hint eq '고향' }">
						<td><select name="hint">
								<option value="출신초" >출신 초등학교는 어디인가요?</option>
								<option value="책 이름">가장 감명 깊게 읽은 책 이름은?</option>
								<option value="고향" selected="selected">본인이 태어난 곳은?</option>
								<option value="어머니">본인의 어머니 성함은?</option>
								
						</select></td>
						</c:when>
						<c:when test="${vo.hint eq '어머니' }">
						<td><select name="hint">
								<option value="출신초" selected="selected">출신 초등학교는 어디인가요?</option>
								<option value="책 이름">가장 감명 깊게 읽은 책 이름은?</option>
								<option value="고향">본인이 태어난 곳은?</option>
								<option value="어머니" selected="selected">본인의 어머니 성함은?</option>
								
						</select></td>
						</c:when>
						
						</c:choose>
					</tr>
					<tr>
						<th>가입 힌트 입력</th>
						<td><textarea rows="3" cols="35" name="hintAnswer" > ${vo.hintAnswer }</textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="right">
						<input type="submit" value="정보수정"  /> 
						<input type="reset" value="다시쓰기" /> 
						<input type="button" value="취소" /></td>
					</tr>
				</table>
			</form>

	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>

