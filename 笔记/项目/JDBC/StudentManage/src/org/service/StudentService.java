package org.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.Dbutil.DButil;
import org.dao.StudentDao;
import org.entity.Student;

public class StudentService {
	  StudentDao dao=new StudentDao();
     public  boolean addStudent(Student student) {
    	  if(!dao.isExist(student.getSno())) {
    		  return dao.addStudent(student);
    	  }
    	  return false;
      }
    public  boolean deleteStudentBySno(int sno) {
    	 if(dao.isExist(sno)) {
    		 
    	return	 dao.deleteStudentBySno(sno);
    	 }
    	 
    	 return false;
     }
	public  boolean updateStudentBySno(int sno,Student student) {
		 if(dao.isExist(sno))
			{
				return dao.updateStudentBySno(sno, student);
				
			}
		 return false;
		 
	 }
	
	 
	public  List<Student> queryAllStudents(){
		
		 
		 
		 
		 return dao.queryAllStudents();
	 }
	public int autoSno() {
		// TODO Auto-generated method stub
		 Object[] params= {};
		String sql="select max(sno) max  from student";
		ResultSet rs=DButil.queryAll(sql, params);
		if(rs!=null)
		{
			try {
				rs.next();
				System.out.println("学号最大"+rs.getInt("max"));
				return rs.getInt("max")+1;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return 1;
	}
    public Student queryStudentByName(String sname) {
    	  return dao.queryStudentByName(sname);
    	
    }
	 
	 
	
}
