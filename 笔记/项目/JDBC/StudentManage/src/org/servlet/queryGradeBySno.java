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
 * Servlet implementation class queryGradeBySno
 */
@WebServlet("/queryGradeBySno")
public class queryGradeBySno extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService service=new GradeService();
		int sno=Integer.parseInt(request.getParameter("sno"));
		Grade student =service.queryGradeBySno(sno);
		request.setAttribute("grade", student);
		
	     
	    if(loginServlet.count==1) {
	    	
	    	//学生查询成绩
	    	
	    	request.getRequestDispatcher("showGradeBySno.jsp").forward(request, response);
	    }
	    else
	       //管理员修改成绩
	    	request.getRequestDispatcher("updateGrade.jsp").forward(request, response);
	    
	    
	    
	    
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
