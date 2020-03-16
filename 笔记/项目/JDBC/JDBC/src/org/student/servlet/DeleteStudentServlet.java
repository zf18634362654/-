package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sno = request.getParameter("sno");
		
		String address = request.getParameter("address");
	    
		IStudentService service=new StudentServiceImpl();
	 
	    boolean  result=service.deleteStudentBySno(sno);
	    
	    response.setContentType("text/html; charset=UTF-8");
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out =response.getWriter();
	    if(result) {
	    	response.sendRedirect("QueryAllStudentsServlet");//删除完成后重新查询展示
	    	
	    }
	    else
	    	out.println("删除失败！");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
