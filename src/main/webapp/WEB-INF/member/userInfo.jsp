<%@ page language='java' contentType='text/html; charset=UTF-8'
    pageEncoding='UTF-8'%>
<%@ include file="../include/header.jsp" %>

	<div class='container'>
		<form class ='border w-50 rounded p-5 mx-auto shadow mb-5 mt-5' 
			action='/memberUpdate.do' method='get'>
			<h3 class='text-center'>회원정보</h3>
			<table class='mt-3 w-100'>	
				<thead>
					<tr>
						<th colspan='2'>
						${requestScope.dto.name}님 회원정보
						</th>
					</tr>
				</thead>		
				<tbody>
					<tr>
						<td>회원번호 </td>
						<td>
							<input class='ms-2 form-control mb-2' type='text' name='uno' 
							value="${requestScope.dto.uno}" readonly/>
						</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td>
							<input class='ms-2 form-control mb-2' type='text' name='uno' 
							value="${requestScope.dto.id}" readonly/>
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td>
							<input class='ms-2 form-control mb-2' type='text' name='uno' 
							value="${requestScope.dto.name}" readonly/>
						</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input class='ms-2 form-control mb-2' type='text' name='email' 
							value="${requestScope.dto.email}"/></td>
					</tr>
					<tr>
						<td>나이</td>
						<td><input class='ms-2 form-control mb-2' type='text' name='age'
							value="${requestScope.dto.age}"
						/></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input class='ms-2 form-control mb-2' type='text' name='tel' size='3'
							value="${requestScope.dto.tel}"
						/></td>
					</tr>
				</tbody>
			</table>
			<div class='mt-5 text-center'>				
				<input type='submit' class='btn btn-primary' value='수정하기'>
				<input type='reset' class='btn btn-secondary' value='취소'>
				<a href='/memberList.do' class='btn btn-info'>리스트</a>
			</div>
		</form>
	</div>
</body>
</html>