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
		var html = "<div id = d" + count + "><input type = 'text' name = 'addText[]'>" 
				+ "<input type = 'button' name = 'removeText' value='삭제' id=de" + count + " onclick = 'del(" + count + ");'> <br/>";
		
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




<style>
div {
	border: 1px solid red;
}

table {
	border-collapse: collapse;
	align: "center";
	width: 80%;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1 align="center">글 작성</h1>
	<hr />
	<br />
		<div>
			<form action="/OurCommunity/vote/registVote" name="form"
				method="post">
				<table style="height: 500;" align="center">
					<tr>
						<th>제목</th>
						<td colspan="3"><input name="v_title" size="148" name="title" /></td>
					</tr>
					<tr>
						<th>마감일</th>
						<td colspan="3"><input type="text" name="end_date" size="148" placeholder="예)20150831"></td>
					</tr>
					<tr>
						<th>선택항목</th>
						<td><input type="button" name = "addTextBox" value="항목 추가" onClick="addTB();"/>
						<br /> </td>
					</tr>
					<tr>
						<td></td>
						<td id = "tableTD"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="button" name="button"
										value="확인" onClick="frmCheck();"></td>
					</tr>
				</table>
			</form>
		</div>					
</body>
</html>