<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.entity.Student"%>
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
<form method="post" action="updateStudentServlet">
<%
Student student=(Student)request.getAttribute("student");

%>
学号:<input name="sno"  value="<%=student.getSno() %>" readonly="readonly" /> <br/>
姓名:<input name="sname"  value="<%=student.getSname() %>"  /> <br/>
性别:<input name="sex"  value="<%=student.getSex() %>" readonly="readonly" /> <br/>
电话:<input name="phone"  value="<%=student.getPhone() %>"  /> <br/>
籍贯:<input name="birthPlace"  value="<%=student.getBirthPlace() %>"  /> <br/>
<input type="submit"  value="更新" /> <br/>   <a href="queryAllStudent">取消</a>
</form>
</f:view>
</body>
</html>