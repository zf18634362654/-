<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- <script type="text/javascript">
function  check(){
	var sno=$('#sno').val();
	var name=$('#sname').val();
	var age=$('#sage').val();
	var address=$('#saddress').val();
	 if(sno<0 ){
		 alert("学号必须大于0");
		 return false
	 }
	 if(name.length<0||name.length>15){
		 alert("名字太长了");
		 return false
	 }
	 
	return true;
} 
</script>
-->


<body>
<form  action="AddStudentServlet"  method="post" ><!-- onsubmit="return check()" -->
学号:<input type="text" name="sno"  id="sno"><br>
姓名:<input type="text" name="name" id="sname" ><br>
年龄:<input type="text" name="age"  id="sage" ><br>
地址:<input type="text" name="address" id="saddress"><br>
<input type="submit" value="提交">

</form>
</body>
</html>