<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="nuc.bean.zfBook" %>
    <%@ page import="java.util.*" %>


<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
    <th>书籍编号</th>
    <th>书籍名字</th>
    <th>书籍出版社</th>
    <th>书籍作者</th>
    <th>操作</th>
</tr>
<% 
List<zfBook>  zfBooks=(List<zfBook>)request.getAttribute("candidates");
if(zfBooks!=null){
for(zfBook candidate:zfBooks){
%>
<tr>
   <td><a href="QueryOneServlet?number=<%= candidate.getBookid() %>"><%=candidate.getBookid() %></a></td>
   <td><%=candidate.getTitle() %></td>
   <td><%=candidate.getPublisher() %></td>
   <td><%=candidate.getAuthor() %></td>
   <td><a href="DeleteServlet?number=<%=candidate.getBookid() %>"> 删除 </a></td>
   
</tr>
<%
}}

%>
<a href="insert.jsp" >添加</a>
</table>
</body>
</html>