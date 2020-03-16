package org.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class logoutServlet
 */
@WebServlet("/logoutServlet")
public class logoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		
		 if(cookies!=null)   
		 {   
		     for(int   i=0;i<cookies.length;i++){
		     String sp = cookies[i].getName();
		     if(sp.equals("studentName"))   
		      {   
		          cookies[i].setMaxAge(0);   
		          response.addCookie(cookies[i]);   
		      }   
		      if(sp.equals("studentSno"))   
		      {   
		          cookies[i].setMaxAge(0);   
		          response.addCookie(cookies[i]);     
		      } 
		    }    
		}
		 //注销COOKIE
		 response.sendRedirect("login.jsp");
		 
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
