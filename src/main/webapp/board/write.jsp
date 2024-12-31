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
	<div class="container mt-5 border p-5 shadow rounded w-75">
    <h3 class="text-center">글쓰기</h3>
    <form action="write.do" method="post">      
        <table class="table table-borderless">
            <tbody>            
                <tr>               
                    <td>작성자</td>
                    <td><input type="text" class="form-control" name="writer"/></td>
                </tr>
                <tr>               
                    <td>제목</td>
                    <td><input type="text" class="form-control" name="title"/></td>
                </tr>
                <tr>               
                    <td>내용</td>
                    <td><textarea class="form-control" name="content"></textarea></td>
                </tr>
                <tr>               
                    <td colspan="2" class="text-center">
                        <input type="submit" class="btn btn-primary" value="등록"/>
                        <a href="list.do" class="btn btn-info">리스트</a>
                    </td>
                </tr>            
            </tbody>
        </table>
    </form>
</div>
</body>
</html>