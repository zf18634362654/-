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
<body>
<%
Grade student=(Grade)request.getAttribute("grade");
%>

<form action="updateGradeServlet" method="post">

学号:<input name="sno"  value="<%=student.getSno()%>" readonly="readonly" /> <br/>
姓名:<input name="sname"  value="<%=student.getSname() %>" readonly="readonly" /> <br/>
英语:<input name="English"  value="<%=student.getEnglish() %>"  /> <br/>
Java:<input name="java"  value="<%=student.getJava() %>" /> <br/>
C:<input name="c"  value="<%=student.getC() %>"  /> <br/>
高数:<input name="math"  value="<%=student.getMath() %>"  /> <br/>
语文:<input name="Chinese"  value="<%=student.getChinese() %>"  /> <br/>
<input type="submit"  value="修改"/>  &nbsp;  <br/>
<a href="managerLogin.jsp">返回主界面</a>


</form>

</body>
</html>