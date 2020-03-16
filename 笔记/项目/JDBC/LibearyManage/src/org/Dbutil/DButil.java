package org.Dbutil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DButil {
	
	private	  static final String  URL ="jdbc:mysql://localhost:3306/libearymanage?serverTimezone=GMT%2B8&characterEncoding=UTF-8";
	  private static 	final	 String  user="root";
	  private static final	 String  pwd ="123456";
	 public static Connection connection=null;
	 public static PreparedStatement pstmt=null;
 public static Connection getConnection(){
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	try {
		return DriverManager.getConnection(URL, user, pwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}
public static   boolean executeUpdate(String sql,Object[] params) 
	{
		 Connection connection=getConnection();
		  PreparedStatement pstmt=null;
		  
		try {
			
		//连接数据库
//		Object[] obs=params;
			
		pstmt=connection.prepareStatement(sql);
//		  pstmt.setStri;ng(1, sno)
			//输入Sql语句  
//setXXX的次数取决于Object数组的个数	
		if(params!=null) {
			 for(int i=0;i<params.length;i++){
				  pstmt.setObject(i+1, params[i]);
				 		  
			  }}
		
		  
			
			int count = pstmt.executeUpdate();
			//执行Sql语句
			if(count>0) {
				
				System.out.println("sql成功");
				return true;
			}
			else {
				System.out.println("sql失败");
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
		finally {
			
				try {
					
					if(pstmt!=null) pstmt.close();
					if(connection!=null) connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
					return false;
				}
		}}
public static  ResultSet  queryAll(String sql,Object[] params) {
	
	
	 
	  ResultSet rs=null;
	try {
		
	connection = getConnection();
	//连接数据库
	
	pstmt=connection.prepareStatement(sql);
		//输入Sql语句
	if(params!=null) {
		 for(int i=0;i<params.length;i++){
			  pstmt.setObject(i+1, params[i]);
			 		  
		  }}
	
		
		rs = pstmt.executeQuery();
		//执行Sql语句
		
		return rs;
		
	}  catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return null;
	}
	catch (Exception e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
		return null;
	}
//	finally {
//		
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(connection!=null) connection.close();
//			} catch (SQLException e) {
//				// TODO 自动生成的 catch 块
//				e.printStackTrace();
//			}
//	}
}



}
		

