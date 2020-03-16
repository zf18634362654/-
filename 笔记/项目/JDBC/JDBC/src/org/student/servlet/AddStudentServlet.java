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


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	/*
	 * *out :  response.getWriter()
	 * application:  request.getServletContext();
	 * session:  request.getSession
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"))  ;
		String address = request.getParameter("address");
	    Student a=new Student(sno,name,age,address);
	    //接受数据出
	    IStudentService service=new StudentServiceImpl();
	   
	    boolean  result=service.addStudent(a);
	   
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out =response.getWriter();
	    if(result) {
	    	request.setAttribute("error","noerror");
	    	
	    }
	    else {
	    	request.setAttribute("error","error" );
	    }
	    request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
