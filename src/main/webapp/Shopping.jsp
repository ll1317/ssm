<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pojo.BookBean,java.util.List,java.util.ArrayList,com.controller.BookController" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">欢迎光临网上书店</h1>
<h2 align="center">下面是您购买的书</h2>
<%
List<BookBean> books=null;
if(session.getAttribute("booshopping")!=null){
	books=(List<BookBean>)session.getAttribute("booshopping");
	
}
else{
	books=new ArrayList<BookBean>();
	
}

%>
<table>
<% 
    
    for(int i=0;i<books.size();i++){
    BookBean boo=books.get(i);
    if(boo.getBookId()!=null){
    	
  %>
  <tr><td><%=boo.getBookId()%></td><td>作者:</td><td><%=boo.getAuthor()%></td><td><%=boo.getPrice()%></td></tr>
  <%
    }
    }
  %>
</table>

</body>
</html>