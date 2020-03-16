package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Grade;
import org.service.GradeService;

/**
 * Servlet implementation class updateGradeServlet
 */
@WebServlet("/updateGradeServlet")
public class updateGradeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    GradeService  service=new GradeService();
	         request.setCharacterEncoding("utf-8");
	         int english=Integer.parseInt(request.getParameter("English"));
				int chinese=Integer.parseInt(request.getParameter("Chinese"));
				int math=Integer.parseInt(request.getParameter("math"));
				int  c=Integer.parseInt(request.getParameter("c"));
				int java=Integer.parseInt(request.getParameter("java"));
				String  sname=request.getParameter("sname");
				int sno=Integer.parseInt(request.getParameter("sno"));
				int sum=english+chinese+math+c+java;
				Grade grade=new Grade(english, chinese, math, c, java, sno, sname, sum);
				service.updateGrade(sno, grade);
		        response.sendRedirect("gradeTableServlet");
		
		
		
	}

	private void service(int sno, Grade grade) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
