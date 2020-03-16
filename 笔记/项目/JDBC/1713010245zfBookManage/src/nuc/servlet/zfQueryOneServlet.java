package nuc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nuc.bean.zfBook;
import nuc.dao.zfBookDao;

/**
 * Servlet implementation class QueryOneServlet
 */
@WebServlet("/QueryOneServlet")
public class zfQueryOneServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int number=Integer.parseInt(request.getParameter("number"));
		zfBookDao zfBookDao=new  zfBookDao();
		zfBook  zfBook=zfBookDao.queryCandidateBySno(number);
		boolean flag=false;
		System.out.println(zfBook);
		if(zfBook!=null) {
			
			request.getSession().setAttribute("zfBook", zfBook);
			
			request.getRequestDispatcher("displayOne.jsp").forward(request, response);
		}
		else {
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("queryOne.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
