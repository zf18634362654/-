package org.student.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class QueryOneStudentServlet
 */
@WebServlet("/QueryOneStudentServlet")
public class QueryOneStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sno = request.getParameter("sno");
		
		String address = request.getParameter("address");
	    
		IStudentService service=new StudentServiceImpl();
	 
	    Student a=service.queryStudentById(sno);
	    
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("utf-8");
	    System.out.println(a);
	    request.setAttribute("student",a);
	    request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
