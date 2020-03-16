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
<form  method="post"  action="insertStudentServlet">
学号:<input name="sno"  value="<%=request.getParameter("autoSno") %>" readonly="readonly" /> <br/>
姓名:<input name="sname"  /><br/>
性别:<input name="sex"  /><br/>
电话:<input name="phone"  /><br/>
籍贯:<input name="birthPlace"  /><br/>
账号:<input name="id"  /><br/>
密码:<input name="pwd" type="password"   /><br/>
<input  type="submit" value="提交" /> &nbsp;<input   type="reset" value="重置"/>
</form>



</f:view>
</body>
</html>