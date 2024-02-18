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
<body>
	<div align="center">
		<table>
			<tr height="100">
				<td align="center" colspan="11"> 
					<font size="6" color="gray">  관리자 차량 관리 페이지 </font> 
				</td>
			</tr>
		</table>
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 이미지 </td>
				<td width="100" align="center"> 제조회사 </td>
				<td width="150" align="center"> 이름 </td>
				<td width="100" align="center"> 분류 </td>
				<td width="100" align="center"> 금액 </td>
				<td width="70" align="center"> 탑승인원 </td>
				<td width="70" align="center"> 차량수  </td>
				<td width="200" align="center"> 차량소개 </td>
				<td width="100" align="center"> 수정 </td>
			</tr>
	
	<c:forEach var="car" items="${ clist }" >
		<tr height="70">	
			<td height="70" align="center">
				<img src="IMG/${ car.img }" height="100">
			</td>
			<td width="100" align="center">${ car.company }</td>
			<td width="150" align="center">${ car.name }</td>
			<td width="100" align="center">
			<c:if test="${ car.category == 1 }"> 소형 </c:if>
			<c:if test="${ car.category == 2 }"> 중형 </c:if>
			<c:if test="${ car.category == 3 }"> 대형 </c:if></td>
			<td width="100" align="center">${ car.price }원</td>
			<td width="70" align="center">${ car.usepeople }</td>
			<td width="70" align="center">${ car.totalQty }</td>
			<td width="200" align="center">${ car.info }</td>
			<td width="90" align="center">
				<button onclick="location.href='/myRentcarMVC2/carUpdate.do?no=${ car.no }'">수정</button>
			</td>
		</tr>
	</c:forEach>		
	
		</table>
		<br>
		<button onclick="location.href='/myRentcarMVC2/carInsert.do'"> 차량 신규 등록 </button>
	</div>
	
</body>
</html>