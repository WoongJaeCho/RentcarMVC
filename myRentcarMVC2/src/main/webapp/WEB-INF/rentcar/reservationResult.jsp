<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table>
			<tr height="100">
				<td align="center"> 
					<font size="6" color="gray"> 차량 예약 완료 화면 </font> 
				</td>
			</tr>
			<tr height="100">
				<td align="center"> 
					<img src="IMG/${ img }" width="470" />
				</td>
			</tr>	
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총예약 금액 ${ totalCar } 원 </font>
				</td>
			</tr>
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총옵션 금액 ${ totalOption } 원 </font>
				</td>
			</tr>			
			<tr height="50">
				<td align="center">
					<font size="5" color="red"> 차량 총 금액 ${ totalOption + totalCar } 원 </font>
				</td>
			</tr>	
		</table>
		<button onclick='location.href="/myRentcarMVC2/main.do"'> 메인화면 </button>
	</div>
</body>
</html>