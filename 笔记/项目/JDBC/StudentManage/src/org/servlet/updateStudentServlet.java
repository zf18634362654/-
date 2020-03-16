package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.service.StudentService;

/**
 * Servlet implementation class updateStudentServlet
 */
@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service=new StudentService();
		request.setCharacterEncoding("utf-8");
		String sname=request.getParameter("sname");
		
		int sno=Integer.parseInt(request.getParameter("sno")) ;
		String sex=request.getParameter("sex");
		
		String phone=request.getParameter("phone");
		String birthPlace=request.getParameter("birthPlace");
		Student student=new Student(sno, sname, sex, phone, birthPlace);
		service.updateStudentBySno(sno, student);
	    response.sendRedirect("queryAllStudent");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
