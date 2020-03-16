<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="nuc.bean.zfBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<%
  zfBook book=(zfBook)session.getAttribute("zfBook");

%>
<form action="UpdateServlet" method="post"  >
书籍编号:<input   name="bookid" value="<%=book.getBookid() %>"   /><br/>
书记名字:<input   name="title" value="<%=book.getTitle() %>"/><br/>
书籍作者:<input   name="author" value="<%=book.getAuthor() %>" /><br/>
出版社:<input  name="publisher" value="<%=book.getPublisher() %>" /><br/>
  <input type="submit" value="修改"  />&nbsp; <a href="QueryAllServlet">返回</a>

</form>
<body>


</body>
</html>