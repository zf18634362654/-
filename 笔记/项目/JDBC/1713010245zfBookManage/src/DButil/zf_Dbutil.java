package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class zf_Dbutil {
	
	 public static Connection connection=null;
	 public static PreparedStatement pstmt=null;
public static Connection getConnection(){
	try {
		
		Class.forName(zf_URL.DBDRIVER);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	try {
		return DriverManager.getConnection(zf_URL.DBURL, zf_URL.DBUSER,zf_URL.DBPASS);
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
			
	
			
		pstmt=connection.prepareStatement(sql);

		if(params!=null) {
			 for(int i=0;i<params.length;i++){
				  pstmt.setObject(i+1, params[i]);
				 		  
			  }}
		
		  
			
			int count = pstmt.executeUpdate();
			
			if(count>0) {
				
				System.out.println("删除成功");
				return true;
			}
			else {
				System.out.println("删除失败");
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
	
}}
