package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import java.io.PrintWriter;

import com.service.IRegService;
import com.service.RegServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;


/**
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//依赖注入
	IRegService serivce = new RegServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String acode = request.getParameter("acode");
		
		int count = serivce.active(acode);
		
		request.setAttribute("count", count);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		String acode = request.getParameter("acode");
		
		int count = serivce.active(acode);
		
		request.setAttribute("count", count);
		request.getRequestDispatcher("/result.jsp").forward(request, response);
		response.setContentType("text/html");

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("不支持post方式访问！！！");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}