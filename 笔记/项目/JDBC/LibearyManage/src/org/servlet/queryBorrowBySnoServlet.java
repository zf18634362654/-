package org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.entity.LBDate;
import org.service.LBService;
import org.serviceImp.LBServiceImp;

/**
 * Servlet implementation class queryBorrowBySnoServlet
 */
@WebServlet("/queryBorrowBySnoServlet")
public class queryBorrowBySnoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");
		LBService service =new LBServiceImp();
		int sno=0;
		Cookie[] cookies=request.getCookies();
		for(Cookie cookie:cookies) {
			if(cookie.getName().equals("studentSno"))
				sno=Integer.parseInt(cookie.getValue());
			
		}
		if(sno!=0)
		{
			List<LBDate> list=service.queryBorrowBook(sno);		
		    request.setAttribute("list", list);
		   request.getRequestDispatcher("borrowBookTable.jsp").forward(request, response);
		
  		
		}
		else
			System.out.println("出错了还书！");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
