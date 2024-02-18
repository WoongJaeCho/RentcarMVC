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
					<font size="6" color="gray"> 차량 예약 완료 페이지 </font> 
				</td>
			</tr>
		</table>
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 이미지 </td>
				<td width="100" align="center"> 이름 </td>
				<td width="100" align="center"> 유저ID </td>
				<td width="150" align="center"> 대여일 </td>
				<td width="60" align="center"> 대여기간 </td>
				<td width="100" align="center"> 금액 </td>
				<td width="60" align="center"> 수량 </td>
				<td width="60" align="center"> 보험 </td>
				<td width="60" align="center"> wifi </td>
				<td width="60" align="center"> 베이비시트 </td>
				<td width="60" align="center"> 네비게이션 </td>
				<td width="90" align="center"> 삭제 </td>
			</tr>
	
	<c:forEach var="car" items="${ clist }" >
		<tr height="70">	
			<td height="70" align="center">
				<img src="IMG/${ car.img }"  width="120" height="70">
			</td>
			<td width="100" align="center">${ car.name }</td>
			<td width="100" align="center">${ car.id }</td>
			<td width="150" align="center">${ car.rday }</td>
			<td width="150" align="center">${ car.dday }</td>
			<td width="100" align="center">${ car.price }원</td>
			<td width="70" align="center">${ car.qty }</td>
			<td width="70" align="center">
			<c:if test="${ car.usein == 1 }"> 적용 </c:if>
			<c:if test="${ car.usein == 2 }"> 미적용 </c:if></td>
			<td width="70" align="center">
			<c:if test="${ car.usewifi == 1 }"> 적용 </c:if>
			<c:if test="${ car.usewifi == 2 }"> 미적용 </c:if></td>
			<td width="70" align="center">
			<c:if test="${ car.useseat == 1 }"> 적용 </c:if>
			<c:if test="${ car.useseat == 2 }"> 미적용 </c:if></td>
			<td width="70" align="center">
			<c:if test="${ car.usenavi == 1 }"> 적용 </c:if>
			<c:if test="${ car.usenavi == 2 }"> 미적용 </c:if></td>
			<td width="90" align="center">
				<button onclick="location.href='/myRentcarMVC2/reservateDelete.do?resSeq=${ car.reserveSeq }&qty=${ car.qty }&no=${ car.no }'">삭제</button>
			</td>
		</tr>
	</c:forEach>		

		</table>
	</div>

</body>
</html>