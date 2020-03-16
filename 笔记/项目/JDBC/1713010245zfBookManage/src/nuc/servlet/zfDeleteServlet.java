package nuc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.api.mysqla.io.NativeProtocol.IntegerDataType;

import nuc.dao.zfBookDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class zfDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		zfBookDao zfBookDao=new zfBookDao();
		int number=Integer.parseInt(request.getParameter("number"));
		System.out.println(number);
		boolean flag=zfBookDao.deleteStudentBySno(number);
		if(flag) {
			response.sendRedirect("QueryAllServlet");
		}
		else {
			PrintWriter out=response.getWriter();
			out.println("删除失败");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
