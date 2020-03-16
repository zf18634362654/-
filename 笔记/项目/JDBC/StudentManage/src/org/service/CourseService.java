package org.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.Dbutil.DButil;
import org.entity.CS;
import org.entity.Course;
import org.entity.Grade;

public class CourseService {
   
	public  List<Course>   queryAllCourse(){
 

		List<Course> courses=new ArrayList<Course>();
		Course course=null;
		  ResultSet rs=null;
		try {
			
		
		//连接数据库
		String sql="select * from Course  ";
		
			
			rs = DButil.queryAll(sql, null);
			//执行Sql语句
			while(rs.next()) {
				String  teacher=rs.getString("teacher");
				String  place=rs.getString("place");
				String  credit=rs.getString("credit");
				String  cname=rs.getString("cname");
				String  cno=rs.getString("cno");
				Date startTime=rs.getDate("startTime");
				
				
			   course=new Course(cno, cname, credit, startTime, place, teacher);
			
				
				courses.add(course);
				
			}
			
			
			
			
			return courses;
			
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
		finally {
			
				try {
					if(rs!=null) rs.close();
					if(DButil.pstmt!=null) DButil.pstmt.close();
					if(DButil.connection!=null) DButil.connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
		
		
		
	}
	
	
	public boolean insertIntoCS(CS cs) {
		Object[] params= {cs.getSno(),cs.getCno()};
		String sql="insert into studentcourse (sno,cno) values(?,?)";
		System.out.println(cs);
		
		return DButil.executeUpdate(sql, params);
		
	}
	public List<Course> queryCourseBySno(int sno) {
		
		List<Course> courses=new ArrayList<Course>();
		Course course=null;
		  ResultSet rs=null;
		try {
			
		
			Object[] params= {sno};
			String sql="select course.* from course,studentcourse where sno=? and studentcourse.cno=course.cno";
		
			
			rs = DButil.queryAll(sql, params);
			//执行Sql语句
			while(rs.next()) {
				String  teacher=rs.getString("teacher");
				String  place=rs.getString("place");
				String  credit=rs.getString("credit");
				String  cname=rs.getString("cname");
				String  cno=rs.getString("cno");
				Date startTime=rs.getDate("startTime");
				
				
			   course=new Course(cno, cname, credit, startTime, place, teacher);
			
				
				courses.add(course);
				
			}
			
			
			
			
			return courses;
			
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
		finally {
			
				try {
					if(rs!=null) rs.close();
					if(DButil.pstmt!=null) DButil.pstmt.close();
					if(DButil.connection!=null) DButil.connection.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
		}
		
		
		
	}
	public boolean deleteCourseBysno(int sno) {
		Object[] params= {sno};
		String sql="delete from studentcourse where sno=? ";
		
		
		
		return DButil.executeUpdate(sql, params);
	}
	public boolean deleteCourseBysno2(int sno,String cno) {
		Object[] params= {sno,cno};
		String sql="delete from studentcourse where sno=? and cno=? ";
		
		
		
		return DButil.executeUpdate(sql, params);
	}
	
	
	
}
