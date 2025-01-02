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
	<div class="container mt-5 border p-5 w-50 shadow rounded">
      <h3 class="text-center mt-3">댓글 상세보기</h3>
      <table class="table table-borderless">
         <form action="addReply.do" method="post">
         <input type="hidden" name="bgroup" value=${dto.bgroup}>
         <input type="hidden" name="bstep" value=${dto.bstep}>
         <input type="hidden" name="bindent" value=${dto.bindent}>
         <tr>
            <td>글번호</td>
            <td><input class="form-control" type="text" name="bid" value=${dto.bid} readonly /></td>
         </tr>
         <tr>
            <td>조회수</td>
            <td><input class="form-control" type="text" name="hit" disabled value=${dto.hit} /></td>
         </tr>
         <tr>
            <td>댓글 작성자</td>
            <td><input class="form-control" type="text" name="writer"/></td>
         </tr>
         <tr>
            <td>댓글 제목</td>
            <td><input class="form-control" type="text" name="title"/></td>
         </tr>
         <tr>
            <td>댓글 내용</td>
            <td><textarea class="form-control" name="content"></textarea></td>
         </tr>
         <tr>
            <td></td>
            <td>
               <input class="btn btn-primary" type="submit" value="댓글등록"/>               
               <a href="list.do" class="btn btn-info">리스트</a>
            </td>
         </tr>
         </form>
      </table>
   </div>
</body>
</html>