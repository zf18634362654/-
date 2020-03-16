package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.CourseService;

/**
 * Servlet implementation class deleteOneCourseBySno
 */
@WebServlet("/deleteOneCourseBySno")
public class deleteOneCourseBySno extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseService service=new CourseService();
		int sno=Integer.parseInt(request.getParameter("sno"));
		String cno=request.getParameter("cno");
		service.deleteCourseBysno2(sno, cno);
		response.sendRedirect("queryCourseBySnoServlet?sno="+sno);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
