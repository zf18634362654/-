<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="addServlet"  method="post">

书籍id:  <input  name="id"   value="<%=request.getParameter("autoBookId") %>" readonly="readonly" /><br/>
书籍名字:<input  name="bookName"  /><br/>
书籍作者:<input  name="author"  /><br/>
书籍出版社:<input  name="publish"  /><br/>
数量:     <input  name="num"  /><br/>
       <input  type="submit" value="添加"  /><br/>

</form>





</body>
</html>