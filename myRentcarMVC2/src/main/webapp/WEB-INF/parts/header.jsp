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
	<form>
	<table>
		<tr>
			<td colspan="4">
			<a href="main.do">
			<img id="logo" alt="" src="./IMG/logo.png" >
			</a>	
			</td>
			<td>
			<c:if test="${ empty log }">
			<p> GUEST 님</p>
			<input type="button" value="회원가입" onclick="location.href='/myRentcarMVC2/userJoin.do'"/> 
			<input type="button" value="로그인" onclick="location.href='/myRentcarMVC2/userLogin.do'"/> 
			</c:if>
			<c:if test="${ log ne null }">
			<p>${ id } 님</p>
			<input type="button" value="내정보" onclick="location.href='/myRentcarMVC2/userInfo.do'"/> 
			<input type="button" value="로그아웃" onclick="location.href='/myRentcarMVC2/userLogout.do'"/> 
			</c:if>
			</td>		
		</tr>
		
		<tr>
			<td>
			<a href="/myRentcarMVC2/reservateCar.do"> 예 약 </a>	
			</td>
			<td>
			<a href="/myRentcarMVC2/reservateUserList.do"> 예약확인 </a>	
			</td>		
			<td>
			<a href="#"> 이용안내 </a>	
			</td>
			<td>
			<a href="#"> 이용후기 </a>	
			</td>		
			<td>
			<a href="#"> 고객센터 </a>	
			</td>		
		</tr>
	</table>
	</form>
	
	<hr>
</body>
</html>