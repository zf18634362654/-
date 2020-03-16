package nuc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import DButil.zf_Dbutil;
import nuc.bean.zfManager;

public class zfManageDao {

	
      	
      public static boolean QueryOne(zfManager zfManager) throws SQLException {
    	 boolean flag=false;
    	 int result=-1;
    	
    	 Connection ct=zf_Dbutil.getConnection();
    	 String sql="select count(*)  from manager where name=? and pwd=?";
    	 PreparedStatement psmt=ct.prepareStatement(sql);
    
    	 psmt.setString(1, zfManager.getName());
    	 psmt.setString(2, zfManager.getPwd());
    	ResultSet rs=psmt.executeQuery();
    	 if(rs.next()) {
    		 result=rs.getInt(1);
    	 }
    	 if(result>0) {
    		 flag=true;
    		 
    	 }
    	 if(rs!=null) rs.close();
    	 if(psmt!=null) psmt.close();
    	 if(ct!=null)  ct.close();
    	 return flag;
     }	
	
	
}
