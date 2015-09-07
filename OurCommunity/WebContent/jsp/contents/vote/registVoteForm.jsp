<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<script>
	var count = 0;
	
	function addTB() {
		count++;
		var html = "<p/><div id = d" + count + "><input type = 'text' name = 'addText[]'>" 
				+ "  <input type = 'button' name = 'removeText' value='삭제' id=de" + count + " onclick = 'del(" + count + ");'> <p/>";
		
		var tdObj = document.getElementById("tableTD");
		
		tdObj.innerHTML += html;
	}
	
	function del(no) {
		var div = document.getElementById("d" + no);
		var parent = div.parentNode;
		parent.removeChild(div);
	}
	

	function frmCheck() {
		var frm = document.form;

		for (var i = 0; i <= frm.elements.length - 1; i++) {
			if (frm.elements[i].name == "addText[]") {
				if (!frm.elements[i].value) {
					alert("텍스트박스에 값을 입력하세요!");
					frm.elements[i].focus();
					return;
					
				} 
			}
		}
		document.form.submit();
	}
</script>


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

a {
	color: white;
	text-decoration: none;
}

.bitcampdiv table td {
	padding-left: 10px;
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
}

.bitcampdiv table th {
	border-bottom: 1px solid #5A5A5A;
	padding: 15px 0;
	white-space: normal;
	background: #1F1F1F;
	color: white;
	text-align: center;
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

.scope {
	color: white;
}
</style>

</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">글 작성</h1>
		<hr />
		<br />
		<div class="layerWrap">
			<form action="/OurCommunity/vote/registVote" name="form"
				method="post">
				<table align="center">
					<tr>
						<th align="center">제목</th>
						<td colspan="3"><input name="v_title" size="148" name="title" /></td>
					</tr>
					<tr>
						<th align="center">마감일</th>
						<td colspan="3"><input type="text" name="end_date" size="60"
							placeholder="예)20150831"></td>
					</tr>
					<tr>
						<th>투표항목추가</th>
						<td>
							<button type="button" class="btn btn-default btn-sm"
								onClick="addTB();">
								<span class="glyphicon glyphicon-plus" /></span> 투표 추가
							</button>
						</td>
					</tr>
					<tr>
						<th align="center">투표항목</th>
						<td id="tableTD"></td>
					</tr>
					<tr>

						<td colspan="2" align="right"><button type="button"
								class="btn btn-default btn-sm" onClick="frmCheck();">
								<span class="glyphicon glyphicon-floppy-disk"></span> 등록
							</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>
</body>
</html>