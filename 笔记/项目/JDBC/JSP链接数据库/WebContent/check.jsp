<%@page import="org.demo.JspCheck"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="org.demo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
 String uname=request.getParameter("uname");
String upwd=request.getParameter("upwd");
JspCheck a=new JspCheck();
int count=a.check(uname, upwd);
if(count==1){
	out.println("登陆成功");
}
else if(count ==0){
	out.println("登陆失败");
}
else{
	out.println("登陆异常");
}
%>








</body>
</html>