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
 * Servlet implementation class queryStudentByNameServlet
 */
@WebServlet("/queryStudentByNameServlet")
public class queryStudentByNameServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   StudentService service=new StudentService();
		   request.setCharacterEncoding("utf-8");
		   String sname=request.getParameter("sname");
		   Student student=service.queryStudentByName(sname);
		   if(student!=null) {
		    request.setAttribute("student", student);
		    request.getRequestDispatcher("update.jsp").forward(request, response);
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
