package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegDAO;
import com.dao.RegDaoJdbc;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
@WebServlet("/ManagerDengluServlet")
public class ManagerDengluServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //得到jsp页面传过来的参数
		String pwd = request.getParameter("pwd");
		
	
		
		if(name.equals("abc")&&pwd.equals("123")){
			
			request.getRequestDispatcher("/managersuccess.jsp").forward(request, response);//转发到成功页面
		}else{
			response.sendRedirect("manager.jsp"); //重定向到首页
		}
	}
	public static void main(String[] args) {
	
	}
 
}

