package org.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Dbutil.DButil;
import org.entity.Grade;
import org.entity.Student;

public class GradeService {

	
	public  List<Grade>   queryAllGrade(){


		List<Grade> grades=new ArrayList<Grade>();
		
		  ResultSet rs=null;
		try {
			
		
		//连接数据库
		String sql="select grade.*,student.sname from grade,student where grade.sno=student.sno  order by sum desc  ";
		
			
			rs = DButil.queryAll(sql, null);
			//执行Sql语句
			while(rs.next()) {
				int sno=rs.getInt("sno");
				int english=rs.getInt("english");
				int chinese=rs.getInt("chinese");
				int math=rs.getInt("math");
				int  c=rs.getInt("c");
				int java=rs.getInt("java");
				String  sname=rs.getString("sname");
				
				int sum=rs.getInt("sum");
				
			
				Grade grade=new Grade(english, chinese, math, c, java, sno, sname, sum);
				
				grades.add(grade);
				
			}
			
			
			
			
			return grades;
			
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
	public Grade queryGradeBySno(int sno) {
		
		Grade grade;
		Object[] params= {sno};
		String sql="select * from grade where sno=?";
		ResultSet rs= DButil.queryAll(sql, params);
		try {
			if(rs.next()) {

				int english=rs.getInt("english");
				int chinese=rs.getInt("chinese");
				int math=rs.getInt("math");
				int  c=rs.getInt("c");
				int java=rs.getInt("java");
				String  sname=rs.getString("sname");
				
				int sum=rs.getInt("sum");
				
			
				 grade=new Grade(english, chinese, math, c, java, sno, sname, sum);
				
				
				return grade;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {
			
				try {
					if(rs!=null)	rs.close();
					if(DButil.pstmt!=null) DButil.pstmt.close();
					if(DButil.connection!=null)  DButil.connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		}
		return null;
		
		
		
	}
	public  boolean  updateGrade(int sno,Grade grade) {
		Object[] params= {grade.getJava(),grade.getC(),grade.getMath(),grade.getChinese(),grade.getEnglish(),grade.getSum(), sno};
		String sql="update grade set java=?,c=?,math=?,chinese=?,english=?, sum=? where  sno=?";
		 return   DButil.executeUpdate(sql, params);
	}
	
	public boolean insertIntoGrade(Student student) {
		Object[] params= {student.getSno(),student.getSname()}; 
		String sql="insert into grade (sno,sname) values(?,?)";
		
		
		
		return DButil.executeUpdate(sql, params);
	}
	
	
	
	
	
}
