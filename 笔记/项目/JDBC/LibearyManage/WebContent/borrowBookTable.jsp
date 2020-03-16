<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="org.entity.LBDate"%>
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
Date now=new Date();

Date today=new Date();
  Calendar cal1 = Calendar.getInstance();
  cal1.setTime(today);
  // 将分钟、秒、毫秒域清零
  cal1.set(Calendar.HOUR_OF_DAY, 0);
  cal1.set(Calendar.MINUTE, 0);
  cal1.set(Calendar.SECOND, 0);
  cal1.set(Calendar.MILLISECOND, 0);
  Date nowReset = cal1.getTime();
List<LBDate> list=(List)request.getAttribute("list");

%>



<center>   

<table>
   <tr>
   
     <th>借书编号</th>
     <th> 书籍编号 </th>
      <th> 书籍名字 </th>           
          <th>学号 </th>
            <th> 姓名 </th>
           <th> 借书日期 </th>
            <th> 还书日期 </th>
             <th> 操作 </th>
             <th>还书提示</th>
   </tr>
   
   <%
   
   for(LBDate lb:list){
	   
   
   
   %>
   
   
   <tr>
     <td><%=lb.getBrid() %></td>
    <td><%=lb.getBookId()%></td>
    <td><%=lb.getBookName() %></td>
    <td><%=lb.getSno() %></td>
    <td><%=lb.getName() %></td>
     <td><%=lb.getBorrowDate() %></td>
      <td><%=lb.getLendDate() %></td>
       <td>  <a href="lendServlet?brid=<%=lb.getBrid()%>&bookId=<%=lb.getBookId()%>">还书</a> </td>
      <td> <% if(nowReset.after(lb.getLendDate())){
      out.print("<font color=\"red\" size=\"18\" face=\"Arial\">哥们这本书该还了！</font>");
      }
	   %>
   </td>
   </tr>
   <%
   
  
   
   
   }
	   
   
   
   %>
   

</table><br/>
<a href="queryAllServlet" >返回 </a>

</center>














</f:view>
</body>
</html>