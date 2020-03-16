<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="org.student.entity.Student" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>
<%
 String error=(String)request.getAttribute("error");
if(error==null){}
else if(error.equals("noerror")){
	out.print("添加成功");
	
}
else if(error.equals("error")){
	out.print("添加失败");
	
}

%>



     <table border="1px">
     <tr>
        <th> 学号</th> 
        <th> 姓名</th> 
        <th> 年龄	</th> 
        <th> 住址</th>  
        <th> 操作</th>                          
            </tr>
        <%
        List<Student> students=(List<Student> )request.getAttribute("students");
           for (Student student:students){	
        
           
        %>
        <tr> 
          <td><a href="QueryOneStudentServlet?sno=<%= student.getSno() %>"><%= student.getSno() %></a> </td>
          <td><%=student.getSname()  %> </td>
          <td><%=student.getSage()  %> </td>
          <td><%=student.getSaddress()  %> </td>
          <td><a href= "DeleteStudentServlet?sno=<%= student.getSno() %>">删除</a> </td>
        </tr>
        
        <%} %>
        
        
        
        
     </table>
     <a href="add.jsp">添加</a>
     
     
     
</body>
</html>