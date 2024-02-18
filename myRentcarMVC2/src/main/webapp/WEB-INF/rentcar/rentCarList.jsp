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
		<tr height="60">
		<td align="center" colspan="3">
			<font size="6" color="gray"> 전체 렌트카 </font>
		</td>
		</tr>	
	<c:forEach var="car" items="${ clist }" varStatus="i">
		<c:if test="${ i.index%3 eq 0 }"> <tr height="240"> </c:if>
						
		<td width="200" align="center">
			<a href="/myRentcarMVC2/carInfo.do?no=${ car.no }">
			<img alt="" src="IMG/${ car.img }" height="220">
			</a>
			<!--  <font size="3" color="gray"> -->
			<p>${ car.company } | ${ car.name }</p>
			<!-- </font> -->
		</td>
		
		<c:if test="${ i.index%3 eq 2 }">  </tr> </c:if>
	</c:forEach>	
	</table>
	
	<hr size="3" color="red">
	<p>
	<font size="4" color="gray"><b>차량 검색 하기</b></font>
	
	<form action="/myRentcarMVC2/carList.do" method="post">
		<font size="3" color="gray"><b>차량 검색 하기</b></font>&nbsp;&nbsp;
		<select name="category">
			<option value="1">소형</option>
			<option value="2">중형</option>
			<option value="3">대형</option>
		</select>
		<input type="submit" value="검색" />&nbsp;&nbsp;
	</form>
	<%-- button은 form 밖에 위치시키기 --%>
	<button onclick="location.href='/myRentcarMVC2/carList.do'">전체 검색</button>
	
</div>
</body>
</html>