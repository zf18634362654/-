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
<f:view>


<form action="queryByNameServlet" method="post">
请输出入要查找的书籍名字:<input name="bookName"  /><input type="submit"  value="查询" />
<%
 if(request.getAttribute("Yes")!=null)
out.print("请输入正确的书籍名字");
%><br/>
<a href="queryAllServlet">返回主界面</a>
</form>
</f:view>
</body>
</html>