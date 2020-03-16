<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="org.entity.Student"%>
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
List<Student> list   =(List)request.getAttribute("list");
%>
<center>
学生信息管理<br/>
<table>
   <tr>
     <th>学号</th>
      <th>姓名</th>
       <th>性别</th>
        <th>电话</th>
         <th>籍贯</th>
          <th>操作</th>
   
   
   </tr>
   <%     
      for(Student student:list){
   
   %>
   <tr>
   <td><%=student.getSno()%></td>
     <td><a href="queryStudentByNameServlet?sname=<%=student.getSname() %>"> <%=student.getSname() %></a> </td>
       <td><%=student.getSex() %></td>
         <td><%=student.getPhone() %></td>
           <td><%=student.getBirthPlace() %></td>
            <td><a href="deleteStudentServlet?sno=<%=student.getSno() %>">删除</a></td>
             
   </tr>   




<% 
}
%>


</table><br/>
<a href="insertStudent.jsp?autoSno=${requestScope.autoSno}">添加学生</a><br/>
<a href="managerLogin.jsp">返回主界面</a>
</center>









</f:view>
</body>
</html>