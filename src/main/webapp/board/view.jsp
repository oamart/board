<%@page import="model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
BoardDTO dto = (BoardDTO)request.getAttribute("dto");
%>
	<div class="container mt-5 border p-5 w-50 shadow rounded">
      <h3 class="text-center mt-3">글 상세보기</h3>
      <table class="table table-borderless">
         <form action="update.do" method="post">         
         <tr>
            <td>글번호</td>
            <td><input class="form-control" name="bid" type="text" value="${dto.bid}" readonly/></td>
         </tr>
         <tr>
            <td>조회수</td>
            <td><input class="form-control" name="hit" type="text" value="${dto.hit}" readonly/></td>
         </tr>
         <tr>
            <td>작성자</td>
            <td><input class="form-control" name="writer" type="text" value="${dto.writer}"/></td>
         </tr>
         <tr>
            <td>제목</td>
            <td><input class="form-control" name="title" type="text" value="${dto.title}"/></td>
         </tr>
         <tr>
            <td>내용</td>
            <td><textarea class="form-control" name="content" name="bcontent">${dto.content}</textarea></td>
         </tr>
         <tr>
            <td></td>
            <td>
               <input class="btn btn-primary" type="submit" value="수정"/>
               <a href="del.do?bid=${dto.bid}" class="btn btn-danger">삭제</a>
               <a href="" class="btn btn-success">답변</a>
               <a href="list.do" class="btn btn-info">리스트</a>
            </td>
         </tr>
         </form>
      </table>
   </div>	
</body>
</html>