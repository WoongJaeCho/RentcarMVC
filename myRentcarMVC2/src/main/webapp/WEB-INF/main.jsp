<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %> 

<c:set var="ctx" value="${ pageContext.request.contextPath }"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<table>
	<!-- header -->
	<tr><td><jsp:include page="./parts/header.jsp"/></td></tr>

	<!-- center -->
	
	<tr><td>
	<c:if test="${ center eq null }">
	<jsp:include page="./parts/center.jsp"/>
	</c:if>
	
	<c:if test="${ center ne null }">
	<jsp:include page="./${ center }.jsp"/>
	</c:if>
	</td></tr>

	<!-- bottom -->
	<tr><td><jsp:include page="./parts/footer.jsp"/></td></tr>
	
	
	
	</table>
</div>
</body>
</html>