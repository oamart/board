<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
    
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body> -->

	<div class="container">
		<form class ="border w-50 rounded p-5 mx-auto shadow mb-5 mt-5" 
			action="/member/memberInsert.do" method="get">
			<h3 class="text-center">회원가입</h3>
			<table class="mt-3 w-100">			
				<tbody>
					<tr>
						<td>이름 : </td>
						<td><input class="ms-2 form-control mb-2" type="text" name="name"/></td>
					</tr>
					<tr>
						<td>아이디 : </td>
						<td><input class="ms-2 form-control mb-2" type="text" name="id"/></td>
					</tr>
					<tr>
						<td>비밀번호 : </td>
						<td><input class="ms-2 form-control mb-2" type="password" name="pw"/></td>
					</tr>
					<tr>
						<td>이메일 : </td>
						<td><input class="ms-2 form-control mb-2" type="text" name="email"/></td>
					</tr>
					<tr>
						<td>나이 : </td>
						<td><input class="ms-2 form-control mb-2" type="text" name="age"/></td>
					</tr>
					<tr>
						<td>전화번호 : </td>
						<td><input class="ms-2 form-control mb-2" type="text" name="tel" size="3"/></td>
					</tr>
				</tbody>
			</table>
			<div class="mt-5 text-center">				
				<input type="submit" class="btn btn-primary" value="회원가입">
				<input type="reset" class="btn btn-secondary" value="취소">
			</div>
		</form>
	</div>
</body>
</html>