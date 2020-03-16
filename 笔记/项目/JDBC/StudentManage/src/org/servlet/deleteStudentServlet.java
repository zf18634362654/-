package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.StudentService;

/**
 * Servlet implementation class deleteStudentServlet
 */
@WebServlet("/deleteStudentServlet")
public class deleteStudentServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     StudentService service=new StudentService();
		   request.setCharacterEncoding("utf-8");
      int sno=Integer.parseInt(request.getParameter("sno")) ;
        service.deleteStudentBySno(sno);
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
