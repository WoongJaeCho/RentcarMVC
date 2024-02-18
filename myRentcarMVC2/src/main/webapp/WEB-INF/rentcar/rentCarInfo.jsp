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

		<form action="/myRentcarMVC2/carSelectOption.do"
			method="post">

			<table>
				<tr height="100">
					<td align="center" colspan="3"><font size="6" color="gray">
							${ car.name } 차량 선택
					</font></td>
				</tr>
				<tr>
					<td rowspan="6" width="500" align="center"><img alt=""
						src="IMG/${ car.img }" width="450"></td>
					<td width="250" align="center">차량이름</td>
					<td width="250" align="center">${ car.name }</td>
				</tr>
				<tr>
					<td width="250" align="center">제조회사</td>
					<td width="250" align="center">${ car.company }</td>
				</tr>
				
				<tr>
					<td width="250" align="center">총 승차인원</td>
					<td width="250" align="center">${ car.usepeople }</td>
				</tr>
				<tr>
					<td width="250" align="center">차량수량</td>
					<td width="250" align="center">
					<select name="qty">
					<c:if test="${ car.totalQty eq 0 }">
						<option value="0" selected >0</option>
					</c:if>
					<c:if test="${ car.totalQty ne 0 }">
					<c:forEach var="c" begin="1" end="${ car.totalQty }">
						<option value="${ c }"> ${ c } </option>
					</c:forEach>
					</c:if>
					</select></td>
				</tr>
				<tr>
					<td width="250" align="center">차량분류</td>
					<td width="250" align="center">
					<c:if test="${ car.category == 1 }"> 소형 </c:if>
					<c:if test="${ car.category == 2 }"> 중형 </c:if>
					<c:if test="${ car.category == 3 }"> 대형 </c:if>
					</td>
				</tr>
				<tr>
					<td width="250" align="center">대여가격</td>
					<td width="250" align="center">${ car.price }원</td>
				</tr>
				<tr>
					<td colspan="3" width="250" align="center">
					
					<c:if test="${ log ne null and car.totalQty ne 0 }" >
						<%-- 이전 차량에 관한 정보 --%> 
						<input type="hidden" name="no" value="${ car.no }" />
						<input type="hidden" name="img" value="${ car.img }" /> 
						<input type="submit" value="옵션선택후 렌트 예약 하기" />
					</c:if>	
					<c:if test="${ log eq null }" >
						<%-- 이전 차량에 관한 정보 --%> 
						<p>로그인 후 예약 가능</p>
					</c:if>	
					<c:if test="${ car.totalQty eq 0 }" >
						<%-- 이전 차량에 관한 정보 --%> 
						<p>예약 가능한 차량 수량 부족</p>
					</c:if>	
						
					</td>
				</tr>
			</table>

			<br />
			<br />
			<br /> <font size="5" color="gray">차랑 정보</font>
			<p> ${ car.info } </p>
		</form>



	</div>
	
	
</body>
</html>