<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.entity.Grade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<%
Grade student=(Grade)request.getAttribute("grade");
%>

<body>
<center>
<table border="1">
<tr>
<th>学号</th>
<th>姓名</th>
<th>英语</th>
<th>Java</th>
<th>C</th>
<th>高数</th>
<th>语文</th>
<th>总分</th>

</tr>

<tr>
<td> <a href="queryGradeBySno?sno=<%=student.getSno() %>"><%=student.getSno() %></a>  </td>
<td><%=student.getSname() %></td>
<td><%=student.getEnglish() %></td>
<td><%=student.getJava() %></td>
<td><%=student.getC() %></td>
<td><%=student.getMath() %></td>
<td><%=student.getChinese() %></td>
<td><%=student.getSum() %></td>
</tr>




</table>


<a href="studentManage.jsp">返回主界面</a>


</center>


</body>
</html>