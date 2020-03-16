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
<%     
String studentName="";
String studentSno="";
Cookie[] cookies=request.getCookies();
for(Cookie cookie:cookies){
	String name=cookie.getName();
	switch(name){
	case "studentSno": studentSno=cookie.getValue();break;
	case "studentName":studentName=cookie.getValue();break;
	default:break;
	
	
	
	}
}

%> 
 

 
 
<center>
借书登记<br/>
<form action="borrowServlet" method="post">
借书编号:<input  name="brid"  value="${requestScope.brid}"  readonly="readonly" /><br/>
书籍名字:<input    value="${requestScope.bookName}" name="bookName"   readonly="readonly" /><br/>
书籍ID:<input    value="${requestScope.bookId}" name="bookId"  readonly="readonly" /><br/>
你的姓名:<input  name="name"  value="<%=studentName %>"  readonly="readonly" /><br/>
你的学号:<input name="sno"  value="<%=studentSno %>"  readonly="readonly" /><br/>

借书日期:<input name="borrowDate"><br/> 
换书日期:<input name="lendDate"><br/>
注意日期格式为YY——MM———DAY 2019-01-01<br/>
<input type="submit" value="确认">&nbsp; <input type="button" value="取消" onclick=window.location.href="queryAllServlet" />



<center/>
</form>
</f:view>
</body>
</html>