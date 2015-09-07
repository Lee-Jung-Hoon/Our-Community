<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: 150px;
	position: absolute;
	top: 180px;
	right: 0px;
}

.ul1 {
	border-bottom: 1px solid black;
	background: #ccccff;
}

.ul3 {
	border-bottom: 1px solid black;
	background: #ffccff;
}

.ul5 {
	border-bottom: 1px solid black;
	background: #00ccff;
}

.ul7 {
	border-bottom: 1px solid black;
	background: #99ff99;
}

.ul1 .ul2 {
	display: none;
}

.ul1 li:hover>.ul2 {
	display: block;
	background: #cc66ff;
}

.ul3 .ul4 {
	display: none;
}

.ul3 li:hover>.ul4 {
	display: block;
	background: #ff66ff;
}

.ul5 .ul6 {
	display: none;
}

.ul5 li:hover>.ul6 {
	display: block;
	background: #0066ff;
}

.sideBar a {
	display: block;
	width: 100%;
	height: 50px;
	line-height: 50px;
	color: black;
	font
}
li {
   list-style: none;
}
</style>
</head>
<body>

	<div class="sideBar" align="center">
      <ul class="ul1">
         <li><a href="#">▶ 공지사항</a>
            <ul class="ul2">
               <li><a href="#">▷ 비트캠프정보</a></li>
               <li><a href="#">▷ 반공지사항</a></li>
               <li><a href="#">▷ 관리자게시판</a></li>
            </ul>
         </li>
      </ul>
      <ul class="ul3">
         <li><a href="#">▶ 커뮤니티</a>
            <ul class="ul4">
               <li><a href="#">▷ 학습자료실</a></li>
               <li><a href="#">▷ 익명게시판</a></li>
               <li><a href="#">▷ 취업정보</a></li>
               <li><a href="#">▷ 포토갤러리</a></li>
            </ul>
         </li>
      </ul>
      <ul class="ul5">
         <li><a href="#">▶ 컨텐츠</a>
            <ul class="ul6">
               <li><a href="#">▷ 투표게시판</a></li>
               <li><a href="#">▷ 오늘의 메뉴</a></li>
            </ul>
         </li>
      </ul>
      <ul class="ul7">
         <li><a href="#">▶ 마이페이지</a>
      </ul>
   </div>
	
</body>

<script type="text/javascript">

 $('.sideBar a').on('mouseenter',function(){
         $(this).parent().animate({
               'margin-left':'-50px', 
               backgroundColor: 'red'   // 바꿀색상
            }, 400         // 시간설정 마우스 오버 시간
         ).siblings().animate({'margin-left':0});
   }).on('mouseleave',function(){
         $(this).parent().animate({
               'margin-left':0,
               backgroundColor: 'blue' // 되돌릴색상      
         }, 400         // 시간설정 마우스 아웃 시간
      );
   });

</script>

</html>