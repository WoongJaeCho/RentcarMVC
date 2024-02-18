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
					<font size="6" color="gray"> 관리자 유저 관리 페이지 </font> 
				</td>
			</tr>
		</table>
		<table border="1">
			<tr height="40">
				<td width="70" align="center"> 번호 </td>
				<td width="100" align="center"> 아이디 </td>
				<td width="100" align="center"> 비밀번호 </td>
				<td width="150" align="center"> 이메일 </td>
				<td width="150" align="center"> 전화번호 </td>
				<td width="100" align="center"> 관심분야 </td>
				<td width="100" align="center"> 직업 </td>
				<td width="70" align="center"> 나이 </td>
				<td width="200" align="center"> 자기소개 </td>
				<td width="90" align="center"> 유저삭제 </td>
			</tr>
	
	<c:forEach var="user" items="${ ulist }" >
		<tr height="70">	
			<td width="70" align="center">${ user.no }</td>
			<td width="100" align="center">${ user.id }</td>
			<td width="100" align="center">${ user.pw }</td>
			<td width="150" align="center">${ user.email }</td>
			<td width="150" align="center">${ user.tel }</td>
			<td width="100" align="center">${ user.hobby }</td>
			<td width="100" align="center">${ user.job }</td>
			<td width="70" align="center">${ user.age }</td>
			<td width="200" align="center">${ user.info }</td>
			<td width="90" align="center">
				<button onclick="location.href='/myRentcarMVC2/adminDeleteUser.do?id=${ user.id }'">삭제</button>
			</td>
		</tr>
	</c:forEach>		

		</table>
	</div>

</body>
</html>