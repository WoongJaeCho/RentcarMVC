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
<form action="/myRentcarMVC2/userJoin.do" method="post">
<table class="table table-bordered" border="1">
	<tr>	
		<td align="center" colspan="2"> 
			<font size="6" color="gray"> 회원가입 </font> 
		</td>
	</tr>
  <tr>
    <td>아이디</td>
    <td><input class="col-12 id" type="text" name="id"/>
	<input type="button" value="ID중복체크" id="checkId" />    
    </td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input class="col-12 pw" type="password" name="pw"/></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input class="col-12" type="text" name="email"/></td>
  </tr>
  <tr>
    <td>전화번호</td>
    <td><input class="col-12" type="text" name="tel"/></td>
  </tr>
  <tr>
		<td>관심분야</td>
		<td>
		<input type="radio" name="hobby" value="독서" checked> 독서
		<input type="radio" name="hobby" value="스포츠"> 스포츠
		<input type="radio" name="hobby" value="게임"> 게임
		<input type="radio" name="hobby" value="영화"> 영화
		<input type="radio" name="hobby" value="기타"> 기타
		</td>
	</tr>
  <tr>
		<td>직업</td>
		<td>
		<select name="job">
		<option value="회사원"> 회사원
		<option value="전문직"> 전문직
		<option value="공무원"> 공무원
		<option value="학생/무직"> 학생/무직
		<option value="기타"> 기타
		</select>
		</td>
	</tr>
  <tr>
    <td>나이</td>
    <td><input class="col-12" type="text" name="age"/></td>
  </tr>
  <tr>
  <td>자기소개</td>
  <td>
  <textarea name="info"></textarea>
  </td>
  </tr>
  <tr>
    <td colspan="2" align="center">
      <input type="button" value="가입" class="col-3 btn btn-primary" onclick="validCheck(form)"/>
      <input type="reset" value="취소" class="col-3 btn btn-warning"/>
    </td>
  </tr>
</table>
</form>
</div>
</body>
</html>

<script type="text/javascript">
let check =0; 

function validCheck(form) {
	if(!form.id.value.trim()){
		alert("아이디를 입력해주세요");
		form.id.focus();
		return false;
	}
	if(!form.pw.value.trim()){
		alert("비밀번호를 입력해주세요");
		form.pw.focus();
		return;
	}
	if(!form.email.value.match(/([\w\.]+)@([\w\.]+)\.(\w+)/g)){
		alert("이메일 형식에 맞게 입력하세요");
		form.email.value = "test@test.com";
		form.email.focus();
		return false;
	}
	if(!form.tel.value.match(/01+\d{1}-\d{3,4}-\d{4}/)){
		alert("전화번호 형식에 맞게 입력하세요");
		form.tel.value = "010-0000-0000";
		form.tel.focus();
		return false;
	}
	if(!form.age.value.trim()){
		alert("나이를 입력해주세요");
		form.age.focus();
		return false;
	} else {
		if(Number(form.age.value.trim()) < 19){
			alert("19세 이상 가입할 수 있습니다.");
			form.age.focus();
			return false;
		}
	}
	
	if(check == 0){
		alert("아이디 중복체크 필요");
		return false;
	} else if(check == -1){
		alert("아이디 중복체크 필요");
		return false;
	} 
	form.submit();
}

	document.querySelector('.btn-warning').addEventListener('click',()=>{
		let id = document.querySelector('.id');
		//id.style.borber = "";
		id.removeAttribute("readonly");
		id.removeAttribute("style");
		check=0;
	})
	
	document.querySelector('#checkId').addEventListener('click',()=>{
		let id = document.querySelector('.id');
		if(!id.value.trim()){
			alert("아이디를 입력해주세요");
			id.value = "";
			id.focus();
			return false;
		}
	
		fetch("validIdAjax.do", {
			method : "POST",
			headers : {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",},
			body : "id="+id.value.trim(),
		})
		
		.then(response => response.text())
		.then(getResult)
		.catch(error => console.log(error));
	});
	
	function getResult(data) {
		console.log(data);
		if(data == "Valid"){
			check = 1;
			alert("사용 가능한 아이디입니다.");
			document.querySelector('.pw').focus();
			document.querySelector('.id').style.border = "3px blue solid";
			document.querySelector('.id').setAttribute("readonly","readonly");
		}
		else if(data == "notValid"){
			check = -1;
			alert("중복된 아이디입니다.");
			document.querySelector('.id').value = "";
			document.querySelector('.id').focus();
			document.querySelector('.id').style.border = "3px red solid";
		}
	}
	
	
</script>