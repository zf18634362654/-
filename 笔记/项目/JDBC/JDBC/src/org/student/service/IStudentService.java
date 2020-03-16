package org.student.service;

import java.util.List;

import org.student.entity.Student;

public interface IStudentService {

	public  boolean addStudent(Student student) ;
    public  boolean deleteStudentBySno(String sno) ;
	public  boolean updateStudentBySno(String sno,Student student) ;
	public  List<Student> queryAllStudents();
	public  Student queryStudentById(String sno) ;

	
	
	
	
	
}
