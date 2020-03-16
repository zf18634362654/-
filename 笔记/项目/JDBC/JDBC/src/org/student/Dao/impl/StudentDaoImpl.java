package org.student.Dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.Dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DButil;



public class StudentDaoImpl implements IStudentDao{
  
  private	  final String  URL ="jdbc:mysql://localhost:3306/test1?serverTimezone=GMT%2B8&characterEncoding=UTF-8";
  private  	final	 String  user="root";
  private	 final	 String  pwd ="123456";
 
 public boolean isExist(String sno)//判断学生是否存在
 {
	 return   queryStudentBySno(sno)==null?false:true;
	 //存在返回 true 不存在false
		 
	 
 } 
public  boolean addStudent(Student student) //添加学生
{
	Object[] params= {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
	 String sql="insert into student (sno,sname,sage,saddress)  values(?,?,?,?)";
     return    DButil.executeUpdate(sql, params);
}
	
	

public    boolean deleteStudentBySno(String sno) //删除学生功能根据学号 
{
	Object[] params= {sno};
	String sql="delete from student where sno=? ";
	 return  DButil.executeUpdate(sql, params);
	 
	
	
	
}

public  boolean updateStudentBySno(String sno,Student student) {
	Object[] params= {student.getSname(),student.getSage(),student.getSaddress(),sno};
	String sql="update student set sname=?,sage=?,saddress=? where sno=?";
	 return   DButil.executeUpdate(sql, params);
}
public  List<Student>   queryAllStudents() {
	List<Student> students=new ArrayList<Student>();
	Student student=null;
	  ResultSet rs=null;
	try {
		
	
	//连接数据库
	String sql="select * from student ";
	
		
		rs = DButil.queryAll(sql, null);
		//执行Sql语句
		while(rs.next()) {
			String sno=rs.getString("sno");
			String name=rs.getString("sname");
			String address=rs.getString("saddress");
			int age=rs.getInt("sage");
			
			student=new Student(sno, name, age, address);
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
@Override
public  Student queryStudentBySno(String sno) {
	// TODO Auto-generated method stub
	Student student;
	Object[] params= {sno};
	String sql="select * from student where sno=?";
	ResultSet rs= DButil.queryAll(sql, params);
	try {
		if(rs.next()) {
			
			String name=rs.getString("sname");
			String address=rs.getString("saddress");
			int age=rs.getInt("sage");
			student=new Student(sno, name, age, address);
			System.out.println("2323");
			
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
@Override
public int getTotalCount() {
	// TODO Auto-generated method stub
	String sql="select count(*) from student";
	 DButil.getTotalCount(sql, null);
	return DButil.getTotalCount(sql, null);
}
@Override
public List<Student> queryStudentsByPage(int currentPage,int pageSize ) {
	// TODO Auto-generated method stub
	return null;
}

}



