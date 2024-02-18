<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function uploadFile(file) {
	if(file.files && file.files[0]){
		var fr = new FileReader();
		fr.onload = function(event) {
			document.getElementById("preview").src=event.target.result;
		};
		fr.readAsDataURL(file.files[0]);
	} else {
		document.getElementById("preview").src="";
	}
}
</script>
<body>
	<div align="center">

		<form action="/myRentcarMVC2/uploadProcess.do" method="post" enctype="multipart/form-data">

			<table >
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">
							신규 차량 등록 페이지
					</font></td>
				</tr>
				<tr>
					<td rowspan="7" width="500" align="center">
					<img alt="" src="IMG/기본 img.png" width="450" id="preview">
					<input type="file" name="ofile" accept="image/*" onchange="uploadFile(this)"/>
					</td>
					<td width="250" align="center">차량이름</td>
					<td width="250" align="center">
					<input type="text" name="name" required="required"/></td>
					
				</tr>
				<tr>
					<td width="250" align="center">제조회사</td>
					<td width="250" align="center">
					<input type="text" name="company" required="required"/></td>
				</tr>
				
				<tr>
					<td width="250" align="center">총 승차인원</td>
					<td width="250" align="center">
					<input type="text" name="usepeople" required="required"/></td>
				</tr>
				<tr>
					<td width="250" align="center">차량수량</td>
					<td width="250" align="center">
					<input type="text" name="totalQty" required="required"/></td>
				</tr>
				<tr>
					<td width="250" align="center">차량분류</td>
					<td width="250" align="center">
					<select name="category" required="required">
					<option value="1" > 소형
					<option value="2" > 중형
					<option value="3" > 대형
					</select>
					</td>
				</tr>
				<tr>
					<td width="250" align="center">대여가격</td>
					<td width="250" align="center">
					<input type="text" name="price" required="required"/></td>
				</tr>
				<tr>
					<td width="250" align="center">차량 소개</td>
					<td width="250" align="center">
					<%-- <input type="text" name="info" value="${ car.info }"/></td> --%>
					<textarea type="text" name="info" /></textarea></td>
				</tr>
				<tr>
					
					<td width="250" align="center" colspan="3">
						<input type="submit" value="차량 신규 등록" />
					</td>
				</tr>
			</table>
		</form>



	</div>
</body>
</html>