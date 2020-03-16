package org.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.Loginer;
import org.entity.Student;
import org.service.loginService;

/**
 * Servlet implementation class qq
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	       
	static  int count=0;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Loginer loginer;
		loginService service=new loginService();
		request.setCharacterEncoding("utf-8");  
		System.out.println(request.getParameter("loginer"));
		String identity=request.getParameter("loginer");
		String id=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		loginer=new Loginer(id, pwd);
        try {
			boolean flag= service.QueryOne(loginer, identity);
			if(flag) {
				if(identity.equals("student")) {
					Student student =service.getStudentMessage(id);	
					Cookie cookie1=new Cookie("sname",student.getSname());
					Cookie cookie2=new Cookie("sno",student.getSno()+"");
					System.out.println("学生名字！！！！"+student.getSname());
					 response.addCookie(cookie1);
					 response.addCookie(cookie2);
					 count=1;
				response.sendRedirect("studentManage.jsp");
				}
				else {
					//跳转管理员界面
					count=-1;
					response.sendRedirect("managerLogin.jsp");
						
				}
				
				
			}
			else {
				request.setAttribute("loginF", 1);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        		
		  
		  
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
