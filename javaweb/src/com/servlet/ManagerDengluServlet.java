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
public class ManagerDengluServlet extends HttpServlet {  //��Ҫ�̳�HttpServlet  ����дdoGet  doPost����
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("name"); //�õ�jspҳ�洫�����Ĳ���
		String pwd = request.getParameter("pwd");
		
	
		
		if(name.equals("abc")&&pwd.equals("123")){
			
			request.getRequestDispatcher("/managersuccess.jsp").forward(request, response);//ת�����ɹ�ҳ��
		}else{
			response.sendRedirect("manager.jsp"); //�ض�����ҳ
		}
	}
	public static void main(String[] args) {
	
	}
 
}

