<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}

.sideBar {
	width: 170px;
	position: absolute;
	top: 180px;
	right: 0px;
}

.ul1 {
	border-bottom: 1px solid black;
	background: #BCB9C1;
}

.ul3 {
	border-bottom: 1px solid black;
	background: #BCB9C1;
}

.ul5 {
	border-bottom: 1px solid black;
	background: #BCB9C1;
}

.ul7 {
	border-bottom: 1px solid black;
	background: #BCB9C1;
}

.ul1 .ul2 {
	display: none;
}

.ul1 li:hover>.ul2 {
	display: block;
	background: #D9DBDE;
}

.ul3 .ul4 {
	display: none;
}

.ul3 li:hover>.ul4 {
	display: block;
	background: #D9DBDE;
}

.ul5 .ul6 {
	display: none;
}

.ul5 li:hover>.ul6 {
	display: block;
	background: #D9DBDE;
}

.ul7 .ul8 {
	display: none;
}

.ul7 li:hover>.ul8 {
	display: block;
	background: #D9DBDE;
}


.sideBar a {
	display: block;
	width: 100%;
	height: 50px;
	line-height: 50px;
	color: #383732;
	font-family: 굴림;
	font-size: 15px;
	font-weight: 600;
}

li {
	list-style: none;
}

.sideBar>ul {
	margin-top: 10px;
}

.sideBar>ul:first-child {
	margin-top: 0;
}
</style>
</head>
<body>

	<div class="sideBar" align="center">
		<ul class="ul1">
			<li><a href="#">▥ Notice</a>
				<ul class="ul2">
					<li><a
						href="/OurCommunity/bitcampboard/NoticeBitcampListBoardController">□
							비트캠프정보</a></li>
					<li><a href="/OurCommunity/ourclassboard/list">□ 반 공지사항</a></li>
					<c:if test="${grade eq '운영자'}"><li><a href="/OurCommunity">▷ 관리자게시판</a></li></c:if>
				</ul></li>
		</ul>
		<ul class="ul3">
			<li><a href="#">▥ Community</a>
				<ul class="ul4">
					<li><a href="/OurCommunity/studyFile/list">□ 학습자료실</a></li>
					<li><a href="/OurCommunity/Anonymity/list">□ 익명게시판</a></li>
					<li><a href="/OurCommunity/workInfo/list">□ 취업정보</a></li>
					<li><a href="/OurCommunity/gallery/list">□ 포토갤러리</a></li>
				</ul></li>
		</ul>
		<ul class="ul5">
			<li><a href="#">▥ Contents</a>
				<ul class="ul6">
					<li><a href="/OurCommunity/vote/listVote">□ 투표게시판</a></li>
					<li><a href="/OurCommunity/menu/list">□ 오늘의 메뉴</a></li>
				</ul></li>
		</ul>
		<ul class="ul7">
			<li><a href="#">▥ MyPage</a>
				<ul class="ul8">
				<%-- <c:if test="${empty grade}"> --%>
				<%-- </c:if> --%>
						<li><a href="/OurCommunity/menu/list">□ 개인정보 수정</a></li>
					<c:if test="${grade eq '운영자'}">
						<li><a href="/OurCommunity/memberInfo/list">□ 회원정보 관리</a></li>
					</c:if>
				</ul></li>
		</ul>
	</div>

</body>

<script type="text/javascript">
	$('.sideBar a').on('mouseenter', function() {
		$(this).parent().animate({
			'margin-left' : '-50px',
			backgroundColor : 'red' // 바꿀색상
		}, 400 // 시간설정 마우스 오버 시간
		).siblings().animate({
			'margin-left' : 0
		});
	}).on('mouseleave', function() {
		$(this).parent().animate({
			'margin-left' : 0,
			backgroundColor : 'blue' // 되돌릴색상      
		}, 400 // 시간설정 마우스 아웃 시간
		);
	});
</script>

</html>