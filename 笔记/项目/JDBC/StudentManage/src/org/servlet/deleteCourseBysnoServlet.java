package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.CourseService;

/**
 * Servlet implementation class deleteCourseBysnoServlet
 */
@WebServlet("/deleteCourseBysnoServlet")
public class deleteCourseBysnoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseService service=new CourseService();
		request.setCharacterEncoding("utf-8");
		int sno=Integer.parseInt(request.getParameter("sno"));
	    service.deleteCourseBysno(sno);
	    response.sendRedirect("studentManage.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
