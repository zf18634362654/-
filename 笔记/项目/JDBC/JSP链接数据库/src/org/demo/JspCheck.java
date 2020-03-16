package org.demo;

import java.sql.*;

public class JspCheck {
	String  URL ="jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
	 String  username="root";
	 String  pwd ="123456";
public int check(String uname,String upwd) {
	   //b.与数据库建立连接
	Connection connection=null; 
	//发送sql语句，执行命令 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	try {
		//a.导入驱动，加入具体的类
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   connection = DriverManager.getConnection(URL, username, pwd);
			/*
			 * stmt = connection.createStatement(); String
			 * sql=" insert into qqq values (121,'qq','qqq') "; int count=
			 * stmt.executeUpdate(sql);
			 */
		   String sql=" select count(*) from users  where uid=? and  upwd=? ";
		   
		   pstmt= connection.prepareStatement(sql);
		   pstmt.setString( 1, uname);
		   pstmt.setString(2, upwd);
		  
		  
		   rs=pstmt.executeQuery();
		   int count=0;
		   if(rs.next()) {
			   count=rs.getInt(1);
			   
		   }
		   return count;
		  
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return -1;
	}catch (ClassNotFoundException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return -1;
	}catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return -1;
	}
	  finally {
		  try {
	   if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(connection!=null)  connection.close();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	   }}
}
