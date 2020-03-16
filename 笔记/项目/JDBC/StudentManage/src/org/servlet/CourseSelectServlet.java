package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.CourseService;

/**
 * Servlet implementation class CourseSelectServlet
 */
@WebServlet("/CourseSelectServlet")
public class CourseSelectServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   CourseService service=new CourseService();
		   request.setAttribute("sno", request.getParameter("sno"));
		   request.setAttribute("list", service.queryAllCourse());
		   request.getRequestDispatcher("CourseSelectTable.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
