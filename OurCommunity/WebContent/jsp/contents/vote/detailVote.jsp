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
</style>


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
			'width' : 1200,
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

		year = sDate.substring(0, 4);
		month = sDate.substr(5, 2) - 1;
		date = sDate.substr(8, 2);
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

	function deleteVOTE() {
		location.href = '/OurCommunity/vote/deleteVote?v_no=${list.v_no}';
	}
</script>

<style>
table {
	width: 100%;
}
</style>
</head>
<body>
	<%@ include file="/jsp/include/topMenu.jsp"%>
	<div class="bitcampdiv">
		<h1 align="center">투표 조회</h1>
		<hr />
		<br />

		<div class="layerWrap">
			<form action="/OurCommunity/web/checkVote" name="detVote">
				<button type="button" class="btn btn-default btn-sm"
					onClick="location.href='/OurCommunity/jsp/contents/vote/registVoteForm.jsp'">
					<span class="glyphicon glyphicon-pencil"></span> 글등록
				</button>
				<button type="button" class="btn btn-default btn-sm"
					onClick="location.href='/OurCommunity/vote/listVote'">
					<span class="glyphicon glyphicon-list-alt"></span> 목록
				</button>
				<c:if test="${id eq list.id}">
					<button type="button" class="btn btn-default btn-sm"
						onClick="deleteVOTE();">
						<span class="glyphicon glyphicon-trash"></span> 글 삭제
					</button>
				</c:if>
				<p>
				<table align="center">

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
				<table align="center">
					<tr>
						<th>투표 통계</th>
						<td colspan="2"><div align="center" id="chart_div"></div></td>
					</tr>
										
					<c:forEach var="item" items="${ilist}">
						<tr>
						<c:if test="${list.v_progress ne '0'}">
						</c:if>
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
		</div>
	</div>
	<%@ include file="/jsp/include/bottomMenu.jsp"%>

</body>
</html>