package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.StudentService;

/**
 * Servlet implementation class queryAllStudent
 */
@WebServlet("/queryAllStudent")
public class queryAllStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentService service=new StudentService(); 
		int autoSno=service.autoSno();
		request.setAttribute("autoSno", autoSno);
		request.setAttribute("list", service.queryAllStudents());
		
	    request.getRequestDispatcher("queryAllStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
