package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Grade;
import org.service.GradeService;
import org.service.StudentService;

/**
 * Servlet implementation class gradeTableServlet
 */
@WebServlet("/gradeTableServlet")
public class gradeTableServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService service=new GradeService(); 
		List<Grade> list=service.queryAllGrade();
		
		  
		
		request.setAttribute("list", service.queryAllGrade());
		
		
		
	    request.getRequestDispatcher("GradeTable.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
