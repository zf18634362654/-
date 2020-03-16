package org.serviceImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.Dbutil.DButil;
import org.entity.Book;
import org.entity.Loginer;
import org.entity.Student;
import org.service.BookService;
import org.service.loginService;



public class loginServiceImp implements loginService {
	public  boolean QueryOne(Loginer loginer,String identity) throws SQLException{
		 
    	 int result=-1;
    	 Object[] params= {loginer.getUser(),loginer.getPwd()};
    	 
    	 
    	 String sql="select count(*)  from "+ identity+"  "+"where id=? and pwd=? ";
    	
         System.out.println(sql);
    	
    	ResultSet rs=DButil.queryAll(sql, params);
    	if(rs!=null){
    	 if(rs.next()) {
    		 result=rs.getInt(1);
    	 }
    	 if(result>0) {
    		return true;
    		 
    	 }
    	}
    	 return false;
	}

	@Override
	public Student getStudentMessage(String id) {
		// TODO Auto-generated method stub
		Object[] params= {id};
		String sql="select sno,sname from student where id=?";
	    
		ResultSet rs=DButil.queryAll(sql, params);
		if(rs!=null) {
			try {
				rs.next();
				String sno=rs.getString("sno");
				String sname=rs.getString("sname"); 
			 Student student=new Student(sno, sname);
			return student;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		
		return null;
	};
	
	
	

}
