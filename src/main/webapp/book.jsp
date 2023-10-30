<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.pojo.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理系统</title>
</head>
<body>
<h1 align="center">图书详细信息如下</h1>
<h2 align="center">点击书籍编号可以查看详细信息</h2>
<%
 List<BookBean> book=null;

 book=(List<BookBean>)session.getAttribute("boo");

%>
<table border ="1" width="30%" align="center" style="border:none;" >
  <tr>
  <td>图书编号:</td>
  <td>图书ISBN编号:</td>
  </tr>
  <% 
    
    for(int i=0;i<book.size();i++){
    BookBean boo=book.get(i);
    if(boo.getBookId()!=null){
    	
  %>
  <tr>
  <td><a href="ShowBookDetailServlet?num=<%=boo.getBookId()%>"><%=boo.getBookId()%></a></td>
  <td><%=boo.getISBN()%></td>
  <td style="border:none;" ><a href='ShoppingServlet?num=<%=boo.getBookId()%>'>加入购物车</a></td>
  </tr>
  
  <%
 
    }
    
    }
  %>
  <tr>
  <td style="border:none;"><a href='Shopping.jsp'>查看购物车</a></td>
  </tr>
  </table>
</body>
</html>