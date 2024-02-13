<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/myRentcarMVC2/userJoin.do" method="post">
<table class="table table-bordered" border="1">
	<tr>	
		<td align="center" colspan="2"> 
			<font size="6" color="gray"> 회원가입 </font> 
		</td>
	</tr>
  <tr>
    <td>아이디</td>
    <td><input class="col-12" type="text" name="id"/></td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input class="col-12" type="password" name="pw"/></td>
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
      <input type="submit" value="가입" class="col-3 btn btn-primary"/>
      <input type="reset" value="취소" class="col-3 btn btn-warning"/>
    </td>
  </tr>
</table>
</form>
</body>
</html>