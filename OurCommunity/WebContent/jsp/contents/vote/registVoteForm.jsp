<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>



<script>
var pTbl;

//Row 추가
function insRow() {
  pTbl = document.getElementById("addTable");
  var pRow = pTbl.insertRow();
  pRow.onmouseover=function(){pTbl.clickedRowIndex=this.rowIndex}; //clickedRowIndex - 클릭한 Row의 위치를 확인;
  var oCell = pRow.insertCell();

  //삽입될 Form Tag
  var frmTag = "<input type=text name=addText[] style=width:150px; height:20px;> ";
  frmTag += "<input type=button value='삭제' onClick='removeRow()' style='cursor:hand'>";
  oCell.innerHTML = frmTag;
}

//Row 삭제
function removeRow() {
  pTbl.deleteRow(pTbl.clickedRowIndex);
}

function frmCheck()
{
  var frm = document.form;
  
  for( var i = 0; i <= frm.elements.length - 1; i++ ){
     if( frm.elements[i].name == "addText[]" )
     {
         if( !frm.elements[i].value ){
             alert("텍스트박스에 값을 입력하세요!");
             frm.elements[i].focus();
             return;
          } else {
        	  document.form.submit(); 
          }
      }
   }
 }
</script>




<style>
	div{
		border: 1px solid red;
		}
	table {
		border-collapse: collapse;	
		align:"center";
		width: 80%;

	}

</style>
</head>
<body>
	<div>
			<form action="/OurCommunity/vote/registVote" name="form" method="post">
	<table align="center" border="1px" >
		<tr>
			<th> 제목 </th>
			<td> <input type="text" name = "v_title" > </td>
		</tr>
		<tr>
		<tr>
			<th> 마감일 </th>
			<td> <input type="text" name = "end_date" value = "예)20150831"> </td>
		</tr>
		<tr>
			<th> 선택항목 </th>
			<td>
			
			
<table width="400" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" bgcolor="#FFFFFF">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
         <td colspan="5" bgcolor="#FFFFFF" height="25" align="left"><input name="addButton" type="button" style="cursor:hand" onClick="insRow()" value="항목추가">
         <font color="#FF0000"></font></td>
        </tr>
        <tr>
         <td height="25">
          <table id="addTable" width="400" cellspacing="0" cellpadding="0" bgcolor="#FFFFFF" border="0">
            <tr>
              <td><input type="text" name="addText[]" style= "width:150px; height:20px;"></td>
              <td align="left"></td>
            </tr>
          </table></td>
        </tr>
       </table>
      </td>
   </tr>
 </table>
 <table width="400" border="0" cellspacing="0" cellpadding="0">
    <tr>
    <td height="10">
    </td>
    </tr>
    <tr>
    <td align="center">
    <input type="button" name="button" value="확인" onClick="frmCheck();">
    </td>
   </tr>
 </table>
			
			</td>
</form>
	</div>
	</tr>
	</table>

</body>
</html>