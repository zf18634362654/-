package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.Dbutil.DButil;

import org.entity.Student;

public class StudentDao {
	public boolean isExist(int sno) {
		  
			Object[] params= {sno};
			String sql="select count(*) from student where sno=?";
			ResultSet rs= DButil.queryAll(sql, params);
			try {
				if(rs.next()) {
					if(rs.getInt(1)>0) {
						return true;
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return false;
	};
	public  boolean addStudent(Student student)  {
		Object[] params= {student.getSno(),student.getSname(),student.getSex(),student.getId(),student.getPwd(),student.getPhone(),student.getBirthPlace()};
		 String sql="insert into student (sno,sname,sex,id,pwd,phone,birthPlace)  values(?,?,?,?,?,?,?)";
	     return    DButil.executeUpdate(sql, params);
	};  

	public    boolean deleteStudentBySno(int sno) {
		Object[] params= {sno};
		String sql="delete from student where sno=? ";
		 return  DButil.executeUpdate(sql, params);
	};
	public  boolean updateStudentBySno(int sno,Student student)  {
		Object[] params= {student.getSname(),student.getSex(),student.getPhone(),student.getBirthPlace(),sno};
		String sql="update student set sname=?,sex=?,phone=?,birthPlace=? where  sno=?";
		 return   DButil.executeUpdate(sql, params);
	};
	public  List<Student>   queryAllStudents(){


		List<Student> students=new ArrayList<Student>();
		Student student=null;
		  ResultSet rs=null;
		try {
			
		
		//连接数据库
		String sql="select * from student ";
		
			
			rs = DButil.queryAll(sql, null);
			//执行Sql语句
			while(rs.next()) {
				int sno=rs.getInt("sno");
				String  sname=rs.getString("sname");
				
				String sex=rs.getString("sex");
				String  phone=rs.getString("phone");
				String birthPlace=rs.getString("birthPlace");
				
				
				
				student=new Student(sno, sname, sex, phone, birthPlace);
				students.add(student);
				
			}
			return students;
			
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

	public Student queryStudentByName(String sname) {

		Student student;
		Object[] params= {sname};
		String sql="select * from student where sname=?";
		ResultSet rs= DButil.queryAll(sql, params);
		try {
			if(rs.next()) {
				
				int sno=rs.getInt("sno");
				
				
				String sex=rs.getString("sex");
				String  phone=rs.getString("phone");
				String birthPlace=rs.getString("birthPlace");
				
				
				
				student=new Student(sno, sname, sex, phone, birthPlace);
				
				return student;
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
	
	
	
	
}
