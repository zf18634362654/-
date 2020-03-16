<?xml version="1.0" encoding="UTF-8" ?>
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
Book book=(Book)request.getAttribute("book");

%>
<form action="updateServlet" method="post"> 
id:<input type="text"  name="id" value="<%=book.getId() %>"   readonly="readonly"  /><br/>
名字:<input type="text"  name="bookName" value="<%=book.getBookName() %>" /> <br/>
作者:<input type="text"  name="author" value="<%=book.getAuthor() %>" /><br/>
出版社:<input type="text"  name="publish" value="<%=book.getPublish() %>" /><br/>
剩余数量:<input type="text"  name="num" value="<%=book.getNum() %>" /><br/>
  <input type="submit" value="修改"  >&nbsp; <a href="queryAllServlet" />返回</a>



</input></form>





</f:view>
</body>
</html>