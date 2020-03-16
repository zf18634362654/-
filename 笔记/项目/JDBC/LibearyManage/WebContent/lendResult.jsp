<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script language=javascript>
          setTimeout('window.location="queryAllServlet"',3000)
      </script>

</head>
<body>
<f:view>
<%   


int flag=(int)request.getAttribute("lendF");
if(flag==1)
out.print("还书成功");
else
	out.print("还书失败！");
%>

<br/>
注意:3s后自动跳转！





</f:view>
</body>
</html>