<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 리스트</h2>
<%
ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
int totalCnt = list.size();
int limitCountPerPage = 10;
int currentPage = request.getAttribute("currentPage") == null ? 1:(int)request.getAttribute("currentPage");
/*
for(int i = 0;i < totalCnt;i++) {
	out.print(list.get(i) + "<br/>");
}
*/

// 각 페이지의 시작 게시글 번호
int begin = (currentPage - 1) * limitCountPerPage;
//각 페이지의 마지막 게시글 번호
int end = begin + limitCountPerPage;
if (end > totalCnt) {
	end = totalCnt;
}
//out.print("begin: " + begin + "<br/>end : " + end);  
for (int i = begin; i < end; i++) {
	out.print(list.get(i) + "<br/>");
}
out.print("<hr />");
// ------------------ page navigation -------------------------------------
//전체 페이지 
int totalPage = (int)Math.ceil((double)totalCnt / limitCountPerPage);
int blockSize = 5;
int currentBlock = request.getAttribute("currBlock") == null ? 0: (int)request.getAttribute("currBlock") ;
// 블락 시작값
int blockStart = currentBlock * blockSize + 1;
// 블락의 마지막 값
int blockEnd = blockStart + (blockSize - 1);
// blockEnd는 totalpage보다 클 수 가 없다.
if (blockEnd > totalPage) blockEnd = totalPage;

//이전 페이지 버튼
if (blockStart-1 > 0) {
%>
	<a href="list.do?currentPage=<%=blockStart-1%>">이전</a>
<%
}
// 페이지 번호 출력
for (int i = blockStart; i <= blockEnd; i++) {
%>
	<a href="list.do?currentPage=<%=i%>"><%=i %></a>
	
<%
}
// 다음 페이지 버튼
if (blockEnd < totalPage) {
%>
	<a href="list.do?currentPage=<%=blockEnd+1%>">다음</a>
<%
}

%>
</body>
</html>