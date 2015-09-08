<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<c:import url="/jsp/include/bootstrap.jsp" />
<style type="text/css">
body {
	font-family: "나눔고딕", "Nanum Gothic", Nanum Gothic, "돋움", Dotum, "굴림",
		Gulim, Open Sans, Verdana, AppleGothic, sans-serif;
	background:
		url("http://www.hanium.or.kr/images/egovframework/cmmn/bg_wrap.gif");
	color: white;
}

.bitcampdiv table {
	border-top: 5px solid #cd5d31;
}

table {
	color: white;
}

table a {
	color: white;
}

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding: 6px 10px;
	border: 0.5px solid #1f1f1f;
	overflow: hidden;
	background: #373737;
	color:white;
}

.bitcampdiv table th {
	text-align: center;
	padding: 13px 10px;
	background: #5A5A5A;
	border: 0.5px solid #2d2d2d;
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

.commentDIV {
	color: black;
}
</style>
<style>
table {
	width: 100%;
	height: 100%;
}

comm_text {
	color: black;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1>회원정보 수정사항</h1>
		<hr />

		<div class="layerWrap">
			<hr />
			<form action="/OurCommunity/memberInfo/modify" method="post">
				<input type="hidden" name="name" value="${update.name}">
				<table>
					<tr>
						<th>아이디</th>
						<td width="40%" class="Id" style="color: black;"><input type="text" name="id"
							 value="${update.id}" /></td>
						<c:choose>
							<c:when test="${update.secession eq '회원' }">
								<th>가입일</th>
								<td width="40%">${update.joinDate}</td>
							</c:when>
							<c:otherwise>
								<th>탈퇴일</th>
								<td width="40%">${update.joinDate}</td>
							</c:otherwise>
						</c:choose>
					</tr>

					<tr>
						<th>이름</th>
						<td width="40%" style="color: white;">${update.name}</td>
						<th>성별</th>
						<td width="40%">${update.gender}</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td colspan="3" width="40%" class="password"><input
							type="text" name="password" style="color: black;"
							value="${update.password}" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td width="40%" style="color: white;" class="email"><input
							type="text" name="emilId" style="color: black;"
							value="${update.emailId}" /> @ <select name="emailDomain" style="color: black;">
								<option value="naver.com">naver.com</option>
								<option value="daum.net">daum.net</option>
								<option value="google.com">google.com</option>
						</select></td>
						<th>등급</th>
						<td width="40%">
							<select name="grade" style="color: black;">
								<option value="운영자">운영자</option>
								<option value="회원">회원</option>
						</select></td>
					</tr>
					<tr>
						<th>주소</th>
						<td width="40%">${update.address}</td>
						<th>전화번호</th>
						<td width="40%">${update.tel}</td>
					</tr>
					<tr>
						<th>힌트</th>
						<td width="40%"><select name="hint"  style="color: black;">
								<option value="출신초">출신 초등학교는 어디인가요?</option>
								<option value="책 이름">가장 감명 깊게 읽은 책 이름은?</option>
								<option value="고향">본인이 태어난 곳은?</option>
								<option value="어머니">본인의 어머니 성함은?</option>
						</select></td>
						<th>힌트정답</th>
						<td width="40%"  style="color: black;">
							<input type="text" name="hintAnswer" value="${update.hintAnswer}"></td>
					</tr>
					<tr>
						<td colspan="4" align="right"><input type="submit" value="수정완료" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>