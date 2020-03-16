<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.entity.Course"%>
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
<%
List<Course> list=(List)request.getAttribute("list");

%>


<center>   
  选修课表<br/>
<table>     
 <tr>
   <th>课程编号  </th>
   <th> 课程名称</th>
   <th> 授课教师 </th>
    <th> 课程学分</th>
       <th> 起始时间</th>
      <th>授课教室</th>
         <th>操作</th>
  

    
 
 </tr>
<%
for(Course course:list){


%>
<tr>
<td><%=course.getCno() %></td>
<td><%=course.getCname() %></td>
<td><%=course.getTeacher() %></td>
<td><%=course.getCredit() %></td>
<td><%=course.getStartTime() %></td>
<td><%=course.getPlace() %></td>
<td > <a href="InsertIntoCSServlet?sno=${requestScope.sno}&cno=<%=course.getCno() %>">选修</a></td>
  


</tr>
<%} %>
</table>
<br/>
<a href="studentManage.jsp">返回主界面</a>



</center>



</f:view>
</body>
</html>