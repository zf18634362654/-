<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script type="text/javascript">
function formReset()
  {
  document.getElementById("myForm").reset()
  }
</script>
</head>
<body background="libeary1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%; 
background-attachment: fixed;" >

  <center>欢迎来到中北大学图书馆！<br/>
    请先登录 <br/>
    
   <form action="loginServlet" id="myForm">
    
     账号:<input type="text" name="user" /><br/>
    密码:<input  type="password" name="pwd" />
    
   
      <br/>  
    
    <select name="loginer">
  <option value ="student">学生</option>
  <option value ="manager">管理员</option>
 
</select>
<input type="submit" value="登陆" /> &nbsp; <input type="button" onclick="formReset()" value="重置" />
<br/>
 <%  if (request.getAttribute("loginF")!=null){
    	out.print("请检查用户名密码或身份是否正确！");
    	
    } %>
</form> 
</center>
</body>




</html>