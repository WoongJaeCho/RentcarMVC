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
 <div align="center" height="600">
<form action="/myRentcarMVC2/userUpdate.do" method="post">
<input type="hidden" name="no" value="${user.no}"/>
<table class='table table-bordered' border="1">
	<tr>	
		<td align="center" colspan="2"> 
			<font size="6" color="gray"> ${ user.id } 회원의 상세보기 </font> 
		</td>
	</tr>
  <tr>
    <td>번호</td>
    <td class="left">${ user.no }</td>
  </tr>
   <tr>
    <td>아이디</td>
    <td class="left">${ user.id }</td>
  </tr>
   <tr>
    <td>비밀번호</td>
    <td class="left"><input class="col-12 pw"  type="password" name="pw"/></td>
  </tr>  
  <tr>
    <td>나이</td>
    <td><input class="col-12"  type="text" name="age" value="${ user.age }"/></td>
  </tr> 
     <tr>
    <td>이메일</td>
    <td><input class="col-12"  type="text" name="email" value="${ user.email }"/></td>
  </tr>
  <tr>
    <td>전화번호</td>
    <td><input class="col-12"  type="text" name="tel" value="${ user.tel }"/></td>
  </tr> 
  <tr>
		<td>관심분야</td>
		<td>
		<input type="radio" name="hobby" value="독서" <c:if test="${ user.hobby eq '독서' }"> checked </c:if>> 독서
		<input type="radio" name="hobby" value="스포츠" <c:if test="${ user.hobby eq '스포츠' }"> checked </c:if>> 스포츠
		<input type="radio" name="hobby" value="게임" <c:if test="${ user.hobby eq '게임' }"> checked </c:if>> 게임
		<input type="radio" name="hobby" value="영화" <c:if test="${ user.hobby eq '영화' }"> checked </c:if>> 영화
		<input type="radio" name="hobby" value="기타" <c:if test="${ user.hobby eq '기타' }"> checked </c:if>> 기타
		</td>
	</tr>
	  <tr>
		<td>직업</td>
		<td>
		<select name="job">
		<option value="회사원" <c:if test="${ user.job eq '회사원' }"> selected </c:if>> 회사원
		<option value="전문직" <c:if test="${ user.job eq '전문직' }">selected</c:if>> 전문직
		<option value="공무원" <c:if test="${ user.job eq '공무원' }">selected</c:if>> 공무원
		<option value="학생/무직" <c:if test="${ user.job eq '학생/무직' }">selected</c:if>> 학생/무직
		<option value="기타" <c:if test="${ user.job eq '기타' }">selected</c:if>> 기타
		</select>
		</td>
	</tr>
	<tr>
  <td>자기소개</td>
  <td>
  <textarea name="info">${ user.info }</textarea>
  </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
       <input type="submit" value="수정하기" class='col-5 btn btn-primary'/>
    </td>
  </tr>
</table>
<c:if test="${ user.id ne 'admin' }">
	<br>
	<hr width="400">
	<br>
       <input type="button" value="회원탈퇴" id='delete' onclick="validCheck(form)"/>
</c:if>
</form>
 </div>
</body>

<script type="text/javascript">
	function validCheck(form) {
		if(!form.pw.value.trim()){
			alert("비밀번호를 입력해주세요");
			form.pw.focus();
			return;
		}
	}
	document.querySelector('#delete').addEventListener('click',()=>{
		let id = "${ user.id }"
		let pw = document.querySelector('.pw').value.trim();
		console.log(id);
		console.log(pw);
		
		fetch("userDelete.do",{
			method : "POST",
			headers : {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",},
			body : "id="+id+"&pw="+pw,
		})
		.then(response => response.text())
		.then(getResult)
		.catch(error => console.log(error));
	})
	
	function getResult(data) {
		console.log(data);
		if(data == "pass"){
			alert("회원 탈퇴 완료 되었습니다.");
			location.href = "main.do";
		}
		else if(data == "false"){
			alert("비밀번호가 일치하지 않습니다.");
		}
	}
	
</script>

</html>