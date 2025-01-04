<%@page import="model.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
		<%@ include file="../include/header.jsp" %>
		                                                                                                 
			<div class='container mt-5'>                                                                        
				<h2>회원 리스트</h2>                                                                            
				<table class='table'>                                                                           
					<thead class='table-dark'>                                                                  
						<tr>                                                                                    
							<th>번호</th>                                                                       
							<th>아이디</th>                                                                     
							<th>비밀번호</th>                                                                   
							<th>이름</th>                                                                       
							<th>나이</th>                                                                       
							<th>이메일</th>                                                                     
							<th>전화번호</th>                                                                   
							<th>삭제</th>                                                                       
						</tr>                                                                                   
					</thead>                                                                                    
					<tbody>                                                                                     
					                                                                                            
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>                                                                                             
							<td>${dto.getUno()}</td>                                                                
							<td><a href='/member/userInfo.do?uno=${dto.getUno()}'>${dto.getId()}</a></td>
							<td>${dto.getPw() }</td>                                                                 
							<td>${dto.getName() }</td>                                                                   
							<td>${dto.getAge() }</td>                                                                    
							<td>${dto.getEmail() }</td>                                                                  
							<td>${dto.getTel() }</td>                                                                    
							<td><a href='/member/memberDelete.do?uno=${dto.getUno()}' 
								class='btn btn-danger btn-sm'>삭제</a></td>                                                                                
						</tr>                                                                                            
					</c:forEach>
						<tr>                                                                                 
							<td colspan='8' class='text-center'><a href='user.jsp' class='btn btn-primary'>회원가입</a></td>                                                               
						</tr>                                                                                         
					</tbody>                                                                                          
				</table>                                                                                              
			</div>	                                                                                                  
		</body>                                                                                                 
		</html>                        
