<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.entity.Book"%>
<%@page import="java.util.List"%>
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

<%   List<Book> list=(List)request.getAttribute("list"); 
       request.setAttribute("flag", 0) ;
%>
 
 <center>
 <center>图书管理</center>
 <table border="1px">
     <tr>  
        <th>id</th>
         <th>名字</th>
          <th>作者</th>
           <th>出版社</th>
            <th>数量</th>
             <th>操作</th>
     
     
     
     </tr>
    <%   for(Book book:list ){ %>
    <tr>
      <td><a href="queryBookByIdServlet?bookId= <%= book.getId() %>" target="main"> <%= book.getId() %> </a> </td>
      <td>  <%= book.getBookName() %>  </td>
      <td> <%= book.getAuthor() %></td>
      <td><%= book.getPublish() %> </td>
      <td><%= book.getNum() %> </td>
      <td> <a href="deleteServlet?id=<%=book.getId() %>">删除</a>   </td>
    
    
    </tr>
 
 
 
 <% }%>
 </table>



</center>
<center><a href="m_insertBook.jsp?autoBookId=${requestScope.autoBookId}">添加书籍</a><br/>
<a href="m_queryAllBorrowTableServlet"> 查看借书信息</a><br/>
<a href="logoutServlet">注销</a>

</center>







</f:view>
</body>
</html>