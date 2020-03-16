<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.List"%>
<%@page import="org.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<f:view>
<%  
List<Book> list=(List)request.getAttribute("list"); 


%>
<center>
<center>您要查找的信息是不是如下</center>

 <table border="2">
   <tr>  
     <th>id</th>
     <th>名字</th>
     <th>作者</th>
     <th>出版社</th>
     <th>剩余数量</th>
   
   
   </tr>
    <%   for(Book book:list ){ %>
     <tr>
       <td><%= book.getId() %></td>
       <td> <%= book.getBookName() %> </td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getPublish() %></td>
        <td><%= book.getNum()%></td>
     </tr>
   <% } %>
     
   
   
 </table>
 
 
<br/><a href="queryAllServlet">返回主界面</a>


</center>






</f:view>
</body>
</html>