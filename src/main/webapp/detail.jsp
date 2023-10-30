<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pojo.BookBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

BookBean boos=(BookBean)request.getAttribute("bookd");
/* session.setAttribute("boos",boos);
session.setAttribute("Price",boos.getPrice());
session.setAttribute("Num",boos.getNum()); */

%>
<h1 align="center">图书详细信息如下</h1>
<h2 align="center">可以修改数量和单价</h2>
<form action="UpdateBookServlet" method="post">
<table border ="1" width="30%" align="center">
<tr><td>图书编号</td><td><%=boos.getBookId()%></td></tr>
<tr><td>图书名字</td><td><%=boos.getBookName()%></td></tr>
<tr><td>图书ISBN编号</td><td><%=boos.getISBN()%></td></tr>
<tr><td>图书作者</td><td><%=boos.getAuthor()%></td></tr>
<tr><td>图书单价</td><td><textarea rows=1 cols=10 name="price"><%=boos.getPrice()%></textarea></td></tr>
<tr><td>图书库存数量</td><td><textarea rows=1 cols=10 name="num"><%=boos.getNum()%></textarea></td></tr>
<tr><td  colspan="2" align="center"><input type="submit" value="修改"></td></tr>
</table>

</form>
</body>
</html>