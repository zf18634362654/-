<%@page import="org.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Student student=(Student)request.getAttribute("student");

%>
<form action="UpdateStudentServlet" method="post">
学号:<input type="text"  name="sno" value="<%=student.getSno() %>"   readonly="readonly"><br/>
姓名:<input type="text"  name="name" value="<%=student.getSname() %>"><br/>
年龄:<input type="text"  name="age" value="<%=student.getSage() %>" ><br/>
地址:<input type="text"  name="address" value="<%=student.getSaddress() %>"><br/>
  <input type="submit" value="修改"  >&nbsp; <a href="QueryAllStudentsServlet">返回</a>


</form>
</body>
</html>