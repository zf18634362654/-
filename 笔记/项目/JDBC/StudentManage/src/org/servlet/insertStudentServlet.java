package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Student;
import org.service.GradeService;
import org.service.StudentService;

/**
 * Servlet implementation class insertStudentServlet
 */
@WebServlet("/insertStudentServlet")
public class insertStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service=new StudentService();
		request.setCharacterEncoding("utf-8");
		String sname=request.getParameter("sname");
		String id=request.getParameter("id");
		int sno=Integer.parseInt(request.getParameter("sno")) ;
		String sex=request.getParameter("sex");
		String pwd=request.getParameter("pwd");
		String phone=request.getParameter("phone");
		String birthPlace=request.getParameter("birthPlace");
		Student student=new Student(sno, sname, id, sex, pwd, phone, birthPlace);
		if(service.addStudent(student)) {
			GradeService service2=new GradeService();
			service2.insertIntoGrade(new Student(sno, sname));
			
			request.getRequestDispatcher("queryAllStudent").forward(request, response);
		
		}
		else
		{
		response.sendRedirect("addFail.jsp");	
		
		
		
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
