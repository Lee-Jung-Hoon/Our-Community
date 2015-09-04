<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	google.load('visualization', '1.0', {
		'packages' : [ 'corechart' ]
	});

	google.setOnLoadCallback(drawChart);

	function drawChart() {

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Topping');
		data.addColumn('number', 'Slices');

		<c:forEach var="item" items="${ilist}">
		data.addRows([ [ "${item.subsection}", Number("${item.count}") ] ]);
		</c:forEach>

		var options = {
			'title' : document.getElementById("title").innerHTML,
			'width' : 600,
			'height' : 500
		};
		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
	
	Date.prototype.getInterval = function(otherDate) {
		gap = this.getTime() - otherDate.getTime();
		var result = Math.floor(gap / (60 * 60 * 24 * 1000));
		return result;
	}

	function voteCheck() {
		var now = new Date();
		//alert("now : " + now);
		
		
		var sDate = "${list.end_date}";
		
		year = sDate.substring(0,4);
		month = sDate.substr(5,2)-1;
		date = sDate.substr(8,2);
		//alert(year+""+month+""+date);
		
		var inputDate = new Date(year, month, date);
				
		//alert(now.getInterval(inputDate));
		var frm = document.detVote;
		if (now.getInterval(inputDate) > 0) {
			alert("투표가 마감 되었습니다");
			return;

		} else if (now.getInterval(inputDate) <= 0) {
			for (var i = 0; i <= frm.elements.length - 1; i++) {
				if (frm.elements[i].name == "voteSubmit") {
					if (!frm.elements[i].value) {
						alert("투표 값을 선택 해주세요!!");
						return false;
					}
				}
			}
			document.detVote.submit();
		}
	}

	function registVote() {
		document.regist.submit();
	}
	function listVote() {
		document.list.submit();
	}
</script>

<style>
table {
	border-collapse: collapse;
	align: "center";
	width: 80%;
}
</style>
</head>
<body>
<%@ include file="/jsp/include/topMenu.jsp"%>
	<h1 align="center">투표 조회</h1>
	<hr />
	<br />
	

	<form action="/OurCommunity/web/checkVote" name="detVote">
		<table border="1px" align="center">
			<tr>
				<td><input type="button" name="regist" value="글쓰기"
					onClick="location.href='/OurCommunity/jsp/contents/vote/registVoteForm.jsp'">
					<input type="button" name="list" value="목록"
					onClick="location.href='/OurCommunity/vote/listVote'"> 
					<c:if test="${id eq list.id}">
						<input type="button" name="deletes" value="투표삭제"
							onClick="location.href='/OurCommunity/vote/deleteVote?v_no=${list.v_no}'">
					</c:if></td>
				<td colspan="3"></td>
			</tr>

			<tr>
				<th>작성자</th>
				<td colspan="3">${list.id}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3" id="title">${list.v_title}</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td>${list.start_date}</td>
				<th>종료일</th>
				<td>${list.end_date}</td>
			</tr>
			<tr>
				<th>투표인원</th>
				<td colspan="3">${list.v_progress}</td>
			</tr>
		</table>
		<table border="1px" align="center">
			<c:forEach var="item" items="${ilist}">
			<c:if test="${list.v_progress ne '0'}">		
			<tr>
				<td colspan="2"><div align="center" id="chart_div"></div></td>
			</tr>
			</c:if>
				<tr>
					<td><input type="radio" name="voteSubmit" id="subsection"
						value="${item.subsection}"> ${item.subsection}<br /></td>
					<td id="cnt">투표수 : ${item.count}</td>
				</tr>
			</c:forEach>
			

			<tr>
				<input type="hidden" name="v_no" value="${list.v_no}">				
				<td colspan="2" align="right"><input type="button"
					name="checkvote" value="투표" onClick="voteCheck();"></td>
			</tr>
		</table>
	</form>


</body>
</html>