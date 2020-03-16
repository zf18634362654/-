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
<%!String sname="";
String sno="";
%>
<%
Cookie[] cookies=request.getCookies();

for(Cookie cookie:cookies){

	if(cookie.getName().equals("sname")){
		sname=cookie.getValue();
	}
	if(cookie.getName().equals("sno")){
		sno=cookie.getValue();
	}
}
%>
<center>
   欢迎你,<%=sname %>同学！<br/>
 <a href="CourseSelectServlet?sno=<%=sno %>">老子要选课</a><br/>
   <a href="queryGradeBySno?sno=<%=sno %>">看下老子的成绩</a><br/>
    <a href="queryCourseBySnoServlet?sno=<%=sno %>">看下老子选的课程</a>
</center>


</f:view>
</body>
</html>