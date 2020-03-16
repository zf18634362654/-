package org.student.service.impl;
//业务逻辑层：逻辑性的增删改查（增：先查后增），对dao层进行组装

import java.util.List;

import org.student.Dao.IStudentDao;
import org.student.Dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
	
	IStudentDao  studentDao=new StudentDaoImpl();
	public  boolean addStudent(Student student) {
		 
		if(!studentDao.isExist(student.getSno())) {
			
			
			 
			
			return studentDao.addStudent(student);
			
		}
		
			System.out.println("此人已存在");
			return false;
			
		
		
		
		
	}
    public  boolean deleteStudentBySno(String sno) {
      if(studentDao.isExist(sno)) {
			
			
			studentDao.deleteStudentBySno(sno);
			
			return true;
			
		}
		else {
			System.out.println("此人不存在");
			return false;
			
		}
    }
	public  boolean updateStudentBySno(String sno,Student student) {
	if(studentDao.isExist(sno)) {
		    
					
			return studentDao.updateStudentBySno(sno, student);
			
		}
		
			System.out.println("此人不在");
			return false;
			
		
	}
	public  List<Student> queryAllStudents(){
		
		return studentDao.queryAllStudents();
	}
	public  Student queryStudentById(String sno) {
		return studentDao.queryStudentBySno(sno);
	}

	 
}
