package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"))  ;
		String address = request.getParameter("address");
	    Student a=new Student(sno,name,age,address);
	    //接受数据出
	    IStudentService service=new StudentServiceImpl();
	   System.out.println(name);
	    boolean  result=service.updateStudentBySno(sno, a);
	   
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out =response.getWriter();
	    if(result) {
	    	response.sendRedirect("QueryAllStudentsServlet");
	    	
	    }
	    else
	    	out.println("修改失败！");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
