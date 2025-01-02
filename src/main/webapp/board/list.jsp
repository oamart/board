<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
   <div class="container mt-5">
      <h3 class="text-center">리스트</h3>
      <table class="table table-border">
         <thead class="table-dark">
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>날짜</th>
            <th>조회수</th>
         </thead>
         <tbody>
         	<c:forEach var="dto" items="${requestScope.list }">
            <tr>
               <td>${dto.bid}</td>
               <td>
               		<a href="view.do?bid=${dto.bid}">
               		<c:forEach begin="1" end="${dto.bindent}">ㄴ
               		</c:forEach>
               		${dto.title }
               		</a>
               	</td>
               <td>${dto.writer }</td>
               <td>${dto.regDate }</td>
               <td>${dto.hit }</td>
            </tr>
         	</c:forEach>            
         </tbody>
      </table>
      <div class="text-center">
         <a href="wform.do" class="btn btn-primary">글쓰기</a>
      </div>
   </div>
</body>
</html>