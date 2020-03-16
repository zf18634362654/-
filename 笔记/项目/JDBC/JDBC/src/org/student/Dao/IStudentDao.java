package org.student.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	public boolean isExist(String sno);
	public  boolean addStudent(Student student) ;	  
	public    Student queryStudentBySno(String sno);
	public    boolean deleteStudentBySno(String sno);
	public  boolean updateStudentBySno(String sno,Student student) ;
	public  List<Student>   queryAllStudents();
	public  int getTotalCount();
	public  List<Student>   queryStudentsByPage(int currentPage,int pageSize);//currentPage当前页数，pageSize页面大小
	
	
	
	
}
