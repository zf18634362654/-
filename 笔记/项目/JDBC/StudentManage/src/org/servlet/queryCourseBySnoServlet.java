package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.CourseService;

/**
 * Servlet implementation class queryCourseBySnoServlet
 */
@WebServlet("/queryCourseBySnoServlet")
public class queryCourseBySnoServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		CourseService service=new CourseService();
		int sno=Integer.parseInt(request.getParameter("sno"));
		  
		   request.setAttribute("list", service.queryCourseBySno(sno));
		   request.getRequestDispatcher("queryCourseBySno.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
